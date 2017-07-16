package com.polaris.aws.repository;

import com.polaris.persistence.entity.AwsServicesGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface AwsServiceGroupRepository extends MongoRepository<AwsServicesGroup, String> {

    AwsServicesGroup findByName(String name);

}
