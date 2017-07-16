package com.polaris.aws.service.impl;

import com.polaris.aws.repository.AwsServiceGroupRepository;
import com.polaris.aws.service.AwsServiceGroupProvider;
import com.polaris.persistence.entity.AwsServicesGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Service
public class AwsServiceGroupProviderImpl implements AwsServiceGroupProvider {

    @Autowired
    private AwsServiceGroupRepository groupsRepository;

    @Override
    public AwsServicesGroup saveOrUpdate(AwsServicesGroup group) {
        return groupsRepository.save(group);
    }

    @Override
    public AwsServicesGroup findByName(String name) {
        return groupsRepository.findByName(name);
    }

    @Override
    public Iterable<AwsServicesGroup> findAll() {
        return groupsRepository.findAll();
    }

    @Override
    public void delete(AwsServicesGroup group) {
        groupsRepository.delete(group);
    }
}
