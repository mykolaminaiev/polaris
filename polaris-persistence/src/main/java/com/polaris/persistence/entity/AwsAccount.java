package com.polaris.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type AwsAccount
 * Created by Serhii_Nosko on 11/27/2015.
 */
@Document
public class AwsAccount {

    @Id
    private String id;

    private String name;

    @Field(value = "access_key")
    private String accessKey;

    @Field(value = "secret_key")
    private String secretKey;

    @DBRef
    private AwsCloudTrailConfiguration cloudTrailConfiguration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public AwsCloudTrailConfiguration getCloudTrailConfiguration() {
        return cloudTrailConfiguration;
    }

}
