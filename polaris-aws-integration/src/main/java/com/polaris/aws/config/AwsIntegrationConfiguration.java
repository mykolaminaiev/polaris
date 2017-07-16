package com.polaris.aws.config;

import com.polaris.config.config.MongoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Serhii on 08.05.2016.
 */
@Configuration
@ComponentScan({"com.polaris.aws.service", "com.polaris.aws.config"})
@EnableMongoRepositories({"com.polaris.aws.repository"})
@EnableMongoAuditing
public class AwsIntegrationConfiguration extends MongoConfiguration {

}
