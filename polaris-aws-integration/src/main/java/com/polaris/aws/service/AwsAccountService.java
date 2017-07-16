package com.polaris.aws.service;


import com.polaris.persistence.entity.AwsAccount;

/**
 * The interface IAwsAccountService
 * Created by Serhii_Nosko on 11/27/2015.
 */
public interface AwsAccountService {

    /**
     * Find aws account by name
     *
     * @param name the account name
     * @return the aws account
     */
    AwsAccount findByName(String name);
}
