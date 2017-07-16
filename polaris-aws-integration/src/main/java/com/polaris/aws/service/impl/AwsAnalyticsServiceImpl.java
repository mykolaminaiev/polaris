package com.polaris.aws.service.impl;

import com.amazonaws.util.IOUtils;
import com.google.gson.Gson;
import com.polaris.aws.model.CloudTrailEvent;
import com.polaris.aws.service.AwsAnalyticsService;
import com.polaris.aws.service.AwsS3Service;
import com.polaris.aws.service.AwsServiceEventProvider;
import com.polaris.common.service.AuditService;
import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import com.polaris.persistence.entity.User;
import com.polaris.persistence.entity.audit.AuditEvent;
import com.polaris.persistence.entity.audit.AuditEventData;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

import static java.lang.String.format;
import static org.apache.commons.lang3.time.DateFormatUtils.ISO_DATETIME_FORMAT;

/**
 * Created by Serhii_Nosko on 5/5/2016.
 */
@Service
public class AwsAnalyticsServiceImpl implements AwsAnalyticsService {

    private static final Logger LOG = LoggerFactory.getLogger(AwsAnalyticsServiceImpl.class);

    private DateTime applicationStart = DateTime.now();
    private Map<String, DateTime> lastScanMap = new ConcurrentHashMap<>();

    @Autowired
    private AwsS3Service s3Service;

    @Autowired
    private AuditService auditService;

    @Autowired
    private UserService userService;

    @Autowired
    private AwsServiceEventProvider eventService;

    @Override
    public void processLatestLogs(AwsAccount awsAccount) {
        AwsCloudTrailConfiguration trailConfiguration = awsAccount.getCloudTrailConfiguration();

        String bucketName = trailConfiguration.getBucket();

        String key = awsAccount.getAccessKey();

        DateTime lastScan = getLastScanDate(key);

        Map<String, Date> filteredData = getFilteredData(awsAccount, bucketName, lastScan, key);

        processData(awsAccount, bucketName, filteredData, lastScan);
    }

    private Map<String, Date> getFilteredData(AwsAccount account, String bucketName, DateTime lastScan, String key) {
        Map<String, Date> result = new HashMap<>();

        // get from s3
        Map<String, Date> keys = s3Service.getFiles(account.getAccessKey(), account.getSecretKey(), bucketName);

        // filter only new items
        keys.entrySet().stream()
                .filter(entry -> lastScan.toDate().before(entry.getValue()))
                .forEach(entry -> result.put(entry.getKey(), entry.getValue()));
        // renew last scan date
        lastScanMap.put(key, DateTime.now());
        return result;
    }

    private void processData(AwsAccount account, String bucketName, Map<String, Date> keys, DateTime lastScan) {
        for (String key : keys.keySet()) {
            String fileData = getLogFileData(account, bucketName, key);
            if (StringUtils.isNoneBlank(fileData)) {
                Converter<String, List<CloudTrailEvent>> converter = new EventConverter(account, bucketName);
                List<CloudTrailEvent> events = converter.convert(fileData);
                LOG.info(format("Analyzing file for %s", ISO_DATETIME_FORMAT.format(lastScan.toDate())));
                logEvents(events, account);
            }
        }
    }

    private void logEvents(List<CloudTrailEvent> events, AwsAccount account) {
        for (CloudTrailEvent event : events) {

            AuditEventData data = new AuditEventData();
            data.setEventName(event.getEventName());
            data.setEventType(event.getEventType());
            data.setEventSource(event.getEventSource());
            data.setSourceIPAddress(event.getSourceIPAddress());
            data.setUserAgent(event.getUserAgent());
            data.setErrorCode(event.getErrorCode());
            data.setErrorMessage(event.getErrorMessage());
            data.setEventTime(event.getEventTime());
            data.setAwsRegion(event.getAwsRegion());

            AuditEvent audit = new AuditEvent();
            User user = userService.findByAccountName(account.getName());
            audit.setCreationDate();
            audit.setUser(user);
            audit.setData(data);

            auditService.logEvent(audit);
        }
    }

    private String getLogFileData(AwsAccount account, String bucketName, String key) {
        String result = null;

        byte[] fileData = s3Service.downloadFile(account.getAccessKey(), account.getSecretKey(), bucketName, key);
        if (fileData != null) {
            try (GZIPInputStream gzippedInputStream = new GZIPInputStream(new ByteArrayInputStream(fileData))) {
                result = new String(IOUtils.toByteArray(gzippedInputStream));
            } catch (IOException e) {
                LOG.error(format("Can't read file %s", key), e);
            }
        }
        return result;
    }

    private DateTime getLastScanDate(String key) {
        DateTime lastScan = lastScanMap.get(key);
        if (lastScan == null) {
            lastScan = applicationStart;
        }
        return lastScan;
    }

    /**
     * Special converter for Cloud Trail's events
     */
    protected final class EventConverter implements Converter<String, List<CloudTrailEvent>> {

        private static final String EVENT_TIME = "eventTime";
        private static final String EVENT_NAME = "eventName";
        private static final String EVENT_TYPE = "eventType";
        private static final String EVENT_SOURCE = "eventSource";
        private static final String SOURCE_IP_ADDRESS = "sourceIPAddress";
        private static final String USER_AGENT = "userAgent";
        private static final String ERROR_CODE = "errorCode";
        private static final String ERROR_MESSAGE = "errorMessage";
        private static final String USER_IDENTITY = "userIdentity";
        private static final String AWS_REGION = "awsRegion";
        private static final String RECORDS = "Records";
        private static final String ACCOUNT_ID = "accountId";
        private static final String REQUEST_PARAMS = "requestParameters";
        private static final String RESPONSE_ELEMENTS = "responseElements";
        private static final String LOG_FILES = "logFiles";

        private AwsAccount account;
        private String bucketName;

        EventConverter(AwsAccount account, String bucketName) {
            this.account = account;
            this.bucketName = bucketName;
        }

        @Override
        @SuppressWarnings("unchecked")
        public List<CloudTrailEvent> convert(String source) {
            List<CloudTrailEvent> result = new ArrayList<>();

            Map structure = parseJson(source);
            List<Map> logFiles = (List<Map>) ObjectUtils.defaultIfNull(structure.get(LOG_FILES), new ArrayList<>());
            for (Map logFile : logFiles) {
                String fileData = getLogFileData(account, bucketName, (String) logFile.get("s3Object"));
                if (fileData == null) {
                    continue;
                }
                Map logFileStructure = parseJson(fileData);
                List<Map> records = (List<Map>) ObjectUtils.defaultIfNull(logFileStructure.get(RECORDS), new ArrayList<>());
                for (Map record : records) {
                    if (!checkJson(record)) {
                        LOG.error("Json structure doesn't match!");
                        continue;
                    }
                    result.add(processRecord(record));
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        private CloudTrailEvent processRecord(Map record) {
            String eventName = String.valueOf(record.get(EVENT_NAME));
            String eventType = String.valueOf(record.get(EVENT_TYPE));
            String eventSource = String.valueOf(record.get(EVENT_SOURCE));
            String sourceIPAddress = String.valueOf(record.get(SOURCE_IP_ADDRESS));
            String userAgent = String.valueOf(record.get(USER_AGENT));
            String errorCode = String.valueOf(record.get(ERROR_CODE));
            String errorMessage = String.valueOf(record.get(ERROR_MESSAGE));

            String accountId = String.valueOf(((Map) record.get(USER_IDENTITY)).get(ACCOUNT_ID));
            String awsRegion = String.valueOf(record.get(AWS_REGION));
            DateTime eventTime = getDate(record);

            Map<String, Object> parameters = new HashMap<>();
            if (record.get(REQUEST_PARAMS) != null) {
                parameters.putAll((Map<String, Object>) record.get(REQUEST_PARAMS));
            }
            if (record.get(RESPONSE_ELEMENTS) != null) {
                parameters.putAll((Map<String, Object>) record.get(RESPONSE_ELEMENTS));
            }

            return new CloudTrailEvent(accountId, awsRegion, eventTime, eventName,
                    eventType, eventSource, sourceIPAddress,
                    userAgent, errorCode, errorMessage, parameters);
        }

        private Map parseJson(String source) {
            return new Gson().fromJson(source, Map.class);
        }

        private boolean checkJson(Map json) {
            boolean eventName = json.containsKey(EVENT_NAME);
            boolean userIdentity = json.containsKey(USER_IDENTITY);
            boolean awsRegion = json.containsKey(AWS_REGION);
            boolean eventTime = json.containsKey(EVENT_TIME);
            return eventName && userIdentity && awsRegion && eventTime;
        }

        private DateTime getDate(Map record) {
            DateTime dt;
            try {
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssX");
                dt = formatter.parseDateTime(String.valueOf(record.get(EVENT_TIME)));
            } catch (IllegalArgumentException e) {
                LOG.warn("Failed to parse date " + String.valueOf(record.get(EVENT_TIME)));
                dt = DateTime.now();
            }
            return dt;
        }
    }
}
