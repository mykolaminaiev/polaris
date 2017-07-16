package com.polaris.management.service.impl;

import com.polaris.common.service.UserService;
import com.polaris.management.model.UserDto;
import com.polaris.management.service.UserManagementService;
import com.polaris.persistence.entity.User;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii on 14.05.2016.
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserService userService;

    @Autowired
    private DozerBeanMapper dozer;

    @Override
    public Iterable<UserDto> findAllUsers() {
        Iterable<User> users = userService.listUsers();
        return null;
    }

    @Override
    public UserDto findById(String id) {
        User user = userService.findById(id);
        return dozer.map(user, UserDto.class);
    }
}
