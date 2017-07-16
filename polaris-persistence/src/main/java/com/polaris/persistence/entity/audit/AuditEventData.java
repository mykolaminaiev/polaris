package com.polaris.persistence.entity.audit;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Serhii on 15.05.2016.
 */
@Embeddable
public class AuditEventData {

    @Column(name = "event_time")
    private DateTime eventTime;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_source")
    private String eventSource;

    @Column(name = "source_ip_address")
    private String sourceIPAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "aws_region")
    private String awsRegion;


    public DateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(DateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAwsRegion() {
        return awsRegion;
    }

    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getSourceIPAddress() {
        return sourceIPAddress;
    }

    public void setSourceIPAddress(String sourceIPAddress) {
        this.sourceIPAddress = sourceIPAddress;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
