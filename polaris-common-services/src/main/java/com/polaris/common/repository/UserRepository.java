package com.polaris.common.repository;

import com.polaris.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Serhii_Nosko on 2016.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String username);

    User findByAwsAccountName(String accountName);
}
