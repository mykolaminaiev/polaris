package com.polaris.management.config;

import com.polaris.config.config.AbstractConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Serhii on 14.05.2016.
 */
@Configuration
@ComponentScan({"com.polaris.management.service"})
public class ManagementConfiguration extends AbstractConfiguration {

}
