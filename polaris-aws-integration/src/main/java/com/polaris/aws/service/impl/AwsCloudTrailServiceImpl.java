package com.polaris.aws.service.impl;

import com.amazonaws.services.cloudtrail.AWSCloudTrail;
import com.amazonaws.services.cloudtrail.model.CreateTrailRequest;
import com.amazonaws.services.cloudtrail.model.DescribeTrailsResult;
import com.amazonaws.services.cloudtrail.model.StartLoggingRequest;
import com.amazonaws.services.cloudtrail.model.Trail;
import com.polaris.aws.model.AwsCloudTrailInfo;
import com.polaris.aws.service.AwsClientsFactory;
import com.polaris.aws.service.AwsCloudTrailService;
import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type AwsCloudTrailService
 * Created by Serhii_Nosko on 11/27/2015.
 */
@Service
public class AwsCloudTrailServiceImpl implements AwsCloudTrailService {

    private static final String BUCKET_NAME = "cloud-trail-logs";

    @Autowired
    private AwsClientsFactory awsClientsFactory;

    public AwsCloudTrailInfo activate(AwsAccount account, String bucketName, String logFilePrefix) {
        AWSCloudTrail client = awsClientsFactory.getCloudTrailClient(account.getAccessKey(), account.getSecretKey());

        AwsCloudTrailConfiguration configuration = buildConfiguration(account, bucketName, logFilePrefix);
        CreateTrailRequest request = new CreateTrailRequest()
                .withName(configuration.getTrail())
                .withS3BucketName(configuration.getBucket())
                .withS3KeyPrefix(configuration.getLogPrefix());
        client.createTrail(request);

        startLogging(client);

        return new AwsCloudTrailInfo(configuration.getTrail(), configuration.getBucket(), configuration.getLogPrefix());
    }

    private void startLogging(AWSCloudTrail client) {
        StartLoggingRequest request = new StartLoggingRequest();
        client.startLogging(request);
    }

    private AwsCloudTrailConfiguration buildConfiguration(AwsAccount account, String bucketName, String logFilePrefix) {
        String trailName = getTrailName(account);
        bucketName = getBucketName(bucketName);
        logFilePrefix = getLogPrefix(account, logFilePrefix);
        return new AwsCloudTrailConfiguration(trailName, bucketName, logFilePrefix);
    }

    private String getTrailName(AwsAccount account) {
        return account.getName();
    }

    private String getBucketName(String bucketName) {
        if (StringUtils.isEmpty(bucketName)) {
            return BUCKET_NAME;
        }
        return bucketName;
    }

    private String getLogPrefix(AwsAccount account, String logPrefix) {
        if (StringUtils.isEmpty(logPrefix)) {
            return account.getName();
        }
        return logPrefix;
    }

    @Override
    public void deactivate() {

    }

    public List<AwsCloudTrailInfo> describe(AwsAccount account) {
        AWSCloudTrail client = awsClientsFactory.getCloudTrailClient(account.getAccessKey(), account.getSecretKey());

        DescribeTrailsResult describeTrailsResult = client.describeTrails();
        List<Trail> trails = describeTrailsResult.getTrailList();

        List<AwsCloudTrailInfo> result = new ArrayList<>();
        trails.forEach(trail -> result.add(new AwsCloudTrailInfo(trail.getTrailARN(), trail.getS3BucketName(), trail.getCloudWatchLogsLogGroupArn())));

        return result;
    }
}
