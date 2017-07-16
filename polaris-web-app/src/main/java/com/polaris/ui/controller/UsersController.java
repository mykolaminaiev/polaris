package com.polaris.ui.controller;

import com.polaris.management.model.UserDto;
import com.polaris.management.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Serhii on 16.04.2016.
 */
@RestController
public class UsersController {

    @Autowired
    private UserManagementService userService;

    @RequestMapping(value = "/users")
    public Iterable<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public UserDto getById2(
            @PathVariable("id")
                    String id) {
        return userService.findById(id);
    }
}
