package com.polaris.aws.model;

/**
 * Created by Serhii_Nosko on 2016.
 */
public class AwsCloudTrailInfo {

    private String trail;

    private String bucket;

    private String logPrefix;

    public AwsCloudTrailInfo(String trail, String bucket, String logPrefix) {
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
