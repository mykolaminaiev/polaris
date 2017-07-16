package com.polaris.management.service;

import com.polaris.management.model.UserDto;

/**
 * Created by Serhii on 14.05.2016.
 */
public interface UserManagementService {

    Iterable<UserDto> findAllUsers();

    UserDto findById(String id);
}
