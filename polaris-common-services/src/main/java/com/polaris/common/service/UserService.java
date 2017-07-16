package com.polaris.common.service;

import com.polaris.persistence.entity.User;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface UserService {

    Iterable<User> listUsers();

    User findById(String id);

    User findByName(String name);

    User findByAccountName(String account);

    User updateUser(User user);
}
