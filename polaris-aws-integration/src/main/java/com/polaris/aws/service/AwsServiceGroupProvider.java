package com.polaris.aws.service;

import com.polaris.persistence.entity.AwsServicesGroup;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface AwsServiceGroupProvider {

    AwsServicesGroup saveOrUpdate(AwsServicesGroup group);

    AwsServicesGroup findByName(String name);

    Iterable<AwsServicesGroup> findAll();

    void delete(AwsServicesGroup group);

}
