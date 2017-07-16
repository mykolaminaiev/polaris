package com.polaris.management.model;

/**
 * Created by Serhii on 14.05.2016.
 */
public class AwsCloudTrailConfigurationDto {

    private String trail;

    private String bucket;

    private String logPrefix;

    public AwsCloudTrailConfigurationDto(String trail, String bucket, String logPrefix) {
        this.trail = trail;
        this.bucket = bucket;
        this.logPrefix = logPrefix;
    }

    public String getTrail() {
        return trail;
    }

    public String getBucket() {
        return bucket;
    }

    public String getLogPrefix() {
        return logPrefix;
    }
}
