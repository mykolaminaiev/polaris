package com.polaris.common.service.impl;

import com.polaris.common.repository.UserRepository;
import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii_Nosko on 2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<User> listUsers() {
        return repository.findAll();
    }

    @Override
    public User findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public User findByAccountName(String name) {
        return findByName(name);
    }

    @Override
    public User updateUser(User user) {
        repository.save(user);
        return user;
    }
}
