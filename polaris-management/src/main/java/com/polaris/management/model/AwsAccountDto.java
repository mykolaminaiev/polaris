package com.polaris.management.model;


/**
 * Created by Serhii on 14.05.2016.
 */
public class AwsAccountDto {

    private String name;

    private String accessKey;

    private String secretKey;

    private AwsCloudTrailConfigurationDto cloudTrailConfiguration;

    public AwsAccountDto(String name, String accessKey, String secretKey, AwsCloudTrailConfigurationDto cloudTrailConfiguration) {
        this.name = name;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.cloudTrailConfiguration = cloudTrailConfiguration;
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

    public AwsCloudTrailConfigurationDto getCloudTrailConfiguration() {
        return cloudTrailConfiguration;
    }
}
