package com.polaris.aws.service;

import com.polaris.persistence.entity.AwsServiceEvent;

/**
 * Created by Serhii on 28.05.2016.
 */
public interface AwsServiceEventProvider {

    Iterable<AwsServiceEvent> findAll();

    AwsServiceEvent findByName(String name);

    Iterable<AwsServiceEvent> saveOrUpdate(Iterable<AwsServiceEvent> events);
}
