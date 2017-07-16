package com.polaris.common.repository;

import com.polaris.persistence.entity.UserSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii on 28.05.2016.
 */
public interface UserSubscriptionRepository extends MongoRepository<UserSubscription, String> {

    UserSubscription findByName(String name);
}
