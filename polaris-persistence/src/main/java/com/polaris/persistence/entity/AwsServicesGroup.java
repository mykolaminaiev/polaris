package com.polaris.persistence.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Document
public class AwsServicesGroup {

    @Id
    private String id;

    private String name;
    @DBRef
    private List<AwsService> services;

    @PersistenceConstructor
    public AwsServicesGroup() {
    }

    public AwsServicesGroup(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AwsService> getServices() {
        return services;
    }

    public void setServices(List<AwsService> services) {
        this.services = services;
    }
}
