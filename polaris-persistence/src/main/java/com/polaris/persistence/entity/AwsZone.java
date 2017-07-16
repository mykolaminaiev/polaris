package com.polaris.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Document
public class AwsZone {

    @Id
    private String id;

    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }
}
