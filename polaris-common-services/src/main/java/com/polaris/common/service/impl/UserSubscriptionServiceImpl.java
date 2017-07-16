package com.polaris.common.service.impl;

import com.polaris.common.repository.UserSubscriptionRepository;
import com.polaris.common.service.UserSubscriptionService;
import com.polaris.persistence.entity.UserSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii on 28.05.2016.
 */
@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    @Autowired
    private UserSubscriptionRepository repository;

    @Override
    public void saveOrUpdate(UserSubscription userSubscription) {
        repository.save(userSubscription);
    }

    @Override
    public UserSubscription findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<UserSubscription> findAll() {
        return repository.findAll();
    }
}
