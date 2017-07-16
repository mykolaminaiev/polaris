package com.polaris.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Document
public class AwsService {

    @Id
    private String id;

    @NotNull
    private String name;

    @DBRef
    private List<AwsServiceEvent> events;

    @PersistenceConstructor
    public AwsService() {
    }

    public AwsService(String name) {
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

    public List<AwsServiceEvent> getEvents() {
        return events;
    }

    public void setEvents(List<AwsServiceEvent> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwsService service = (AwsService) o;

        return name.equals(service.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
