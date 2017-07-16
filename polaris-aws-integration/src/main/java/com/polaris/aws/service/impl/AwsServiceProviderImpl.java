package com.polaris.aws.service.impl;

import com.polaris.aws.repository.AwsServiceRepository;
import com.polaris.aws.service.AwsServiceProvider;
import com.polaris.persistence.entity.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Service
public class AwsServiceProviderImpl implements AwsServiceProvider {

    @Autowired
    private AwsServiceRepository repository;

    public Iterable<AwsService> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<AwsService> saveOrUpdate(Iterable<AwsService> services) {
        return repository.save(services);
    }

    @Override
    public AwsService findByName(String name) {
        return repository.findByName(name);
    }
}
