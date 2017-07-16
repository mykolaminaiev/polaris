package com.polaris.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Serhii_Nosko on 11/27/2015.
 */
@Document
public class AwsCloudTrailConfiguration {

    @Id
    private String id;

    private String trail;

    private String bucket;

    @Field(value = "log_prefix")
    private String logPrefix;

    public AwsCloudTrailConfiguration() {
    }

    public AwsCloudTrailConfiguration(String trail, String bucket, String logPrefix) {
        this.trail = trail;
        this.bucket = bucket;
        this.logPrefix = logPrefix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
