package com.polaris.aws.service.impl;

import com.polaris.aws.repository.AwsServiceEventRepository;
import com.polaris.aws.service.AwsServiceEventProvider;
import com.polaris.persistence.entity.AwsServiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii on 28.05.2016.
 */
@Service
public class AwsServiceEventProviderImpl implements AwsServiceEventProvider {

    @Autowired
    private AwsServiceEventRepository awsServiceEventRepository;

    @Override
    public Iterable<AwsServiceEvent> findAll() {
        return awsServiceEventRepository.findAll();
    }

    @Override
    public AwsServiceEvent findByName(String name) {
        return awsServiceEventRepository.findByName(name);
    }

    @Override
    public Iterable<AwsServiceEvent> saveOrUpdate(Iterable<AwsServiceEvent> events) {
        return awsServiceEventRepository.save(events);
    }
}
