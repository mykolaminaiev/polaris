package com.polaris.persistence.entity;

import com.polaris.persistence.entity.audit.AuditEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Document
public class User {

    @Id
    private String id;

    private String name;

    private String password;

    private String email;

    @DBRef
    private Organization organization;

    @DBRef
    private AwsAccount awsAccount;

    @DBRef(lazy = true)
    private List<AuditEvent> events;

    @DBRef(lazy = true)
    private List<UserSubscription> subscriptions;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AwsAccount getAwsAccount() {
        return awsAccount;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
