package com.polaris.aws.service.impl;

import com.polaris.aws.repository.AwsAccountRepository;
import com.polaris.aws.service.AwsAccountService;
import com.polaris.persistence.entity.AwsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type AwsAccountService
 * Created by Serhii_Nosko on 11/27/2015.
 */
@Service
public class AwsAccountServiceImpl implements AwsAccountService {

    @Autowired
    private AwsAccountRepository awsAccountRepository;

    public AwsAccount findByName(String name) {
        return awsAccountRepository.findByName(name);
    }
}
