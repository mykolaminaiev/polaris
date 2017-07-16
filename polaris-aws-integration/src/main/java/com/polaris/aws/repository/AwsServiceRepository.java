package com.polaris.aws.repository;

import com.polaris.persistence.entity.AwsService;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface AwsServiceRepository extends MongoRepository<AwsService, String> {
    AwsService findByName(String name);
}
