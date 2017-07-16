package com.polaris.config.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Mykola_Minaiev
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.polaris.common.repository")
@EnableMongoAuditing
public class MongoConfiguration extends AbstractMongoConfiguration {

    private static final String DB_NAME = "polaris";

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("ec2-34-211-130-179.us-west-2.compute.amazonaws.com", 27017);
    }
}
