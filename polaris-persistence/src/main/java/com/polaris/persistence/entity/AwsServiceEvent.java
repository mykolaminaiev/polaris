package com.polaris.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Serhii on 28.05.2016.
 */
@Document
public class AwsServiceEvent {

    @Id
    private String id;

    @NotNull
    private String name;

    @DBRef(lazy = true)
    private List<UserSubscription> userSubscriptions;

    @PersistenceConstructor
    public AwsServiceEvent() {
    }

    public AwsServiceEvent(String name) {
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
}
