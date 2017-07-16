package com.polaris.common.config;

import com.polaris.config.config.MongoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Serhii_Nosko on 4/19/2016.
 */
@Configuration
@ComponentScan({"com.polaris.common.config", "com.polaris.common.service"})
public class CommonServicesConfiguration extends MongoConfiguration {

}
