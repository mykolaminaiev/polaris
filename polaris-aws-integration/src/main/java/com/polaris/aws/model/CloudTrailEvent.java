package com.polaris.aws.model;

import org.joda.time.DateTime;

import java.util.Map;

/**
 * Created by Serhii on 14.05.2016.
 */
public class CloudTrailEvent {

    private String accountId;

    private String awsRegion;

    private DateTime eventTime;

    private String eventName;

    private String eventType;

    private String eventSource;

    private String sourceIPAddress;

    private String userAgent;

    private String errorCode;

    private String errorMessage;

    private Map<String, Object> parameters;

    public CloudTrailEvent(String accountId, String awsRegion, DateTime eventTime,
                           String eventName, String eventType, String eventSource,
                           String sourceIPAddress, String userAgent,
                           String errorCode, String errorMessage, Map<String, Object> parameters) {
        this.accountId = accountId;
        this.awsRegion = awsRegion;
        this.eventTime = eventTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventSource = eventSource;
        this.sourceIPAddress = sourceIPAddress;
        this.userAgent = userAgent;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.parameters = parameters;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAwsRegion() {
        return awsRegion;
    }

    public DateTime getEventTime() {
        return eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventSource() {
        return eventSource;
    }

    public String getSourceIPAddress() {
        return sourceIPAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
