package com.polaris.aws.service;

import com.polaris.persistence.entity.AwsService;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface AwsServiceProvider {
    AwsService findByName(String name);

    Iterable<AwsService> findAll();

    Iterable<AwsService> saveOrUpdate(Iterable<AwsService> services);
}
