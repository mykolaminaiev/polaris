package com.polaris.aws.repository;

import com.polaris.persistence.entity.AwsServiceEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii on 28.05.2016.
 */
public interface AwsServiceEventRepository extends MongoRepository<AwsServiceEvent, String> {
    AwsServiceEvent findByName(String name);
}
