package com.polaris.aws.repository;

import com.polaris.persistence.entity.AwsAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mykola_Minaiev
 */
public interface AwsAccountRepository extends MongoRepository<AwsAccount, String> {
    AwsAccount findByName(String name);
}
