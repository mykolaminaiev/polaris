package com.polaris.common.repository;

import com.polaris.persistence.entity.Instance;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii on 15.05.2016.
 */
public interface InstanceRepository extends MongoRepository<Instance, String> {
}
