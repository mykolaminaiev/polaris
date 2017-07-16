package com.polaris.management.model;

import com.polaris.persistence.entity.AwsAccount;

/**
 * Created by Serhii on 14.05.2016.
 */
public class UserDto {

    private String username;

    private String password;

    private String email;

    private AwsAccount awsAccount;

    public UserDto(String username, String password, String email, AwsAccount awsAccount) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.awsAccount = awsAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public AwsAccount getAwsAccount() {
        return awsAccount;
    }
}
