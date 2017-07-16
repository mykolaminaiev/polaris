package com.polaris.common;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.polaris.common.service.impl.OrganizationServiceImpl;
import com.polaris.common.service.impl.UserServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Mykola_Minaiev
 */
@Configuration
@ComponentScan(basePackageClasses = {
        OrganizationServiceImpl.class,
        UserServiceImpl.class
})
@EnableMongoRepositories(basePackages = "com.polaris.common.repository")
public class TestMongoConfig extends AbstractMongoConfiguration {
    private static final String DB_NAME = "polaris-test";

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost", 12345);
    }
}
