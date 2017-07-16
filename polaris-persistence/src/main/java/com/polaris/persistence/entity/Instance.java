package com.polaris.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by Serhii on 15.05.2016.
 */
@Document
public class Instance {

    @Id
    private String id;

    public String getId() {
        return id;
    }
}
