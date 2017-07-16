package com.polaris.common.service;

import com.polaris.persistence.entity.UserSubscription;

/**
 * Created by Serhii on 28.05.2016.
 */
public interface UserSubscriptionService {

    void saveOrUpdate(UserSubscription userSubscription);

    UserSubscription findByName(String name);

    Iterable<UserSubscription> findAll();
}
