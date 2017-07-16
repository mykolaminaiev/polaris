package com.polaris.persistence.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by Serhii on 28.05.2016.
 */
@Document
public class UserSubscription {

    @Id
    private String id;

    private String name;

    private User user;

    @DBRef
    private List<AwsServiceEvent> events;

}
