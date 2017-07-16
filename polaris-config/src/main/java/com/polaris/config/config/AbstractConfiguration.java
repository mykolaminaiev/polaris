package com.polaris.config.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author Mykola_Minaiev
 */
public class AbstractConfiguration {
    @Bean
    public DozerBeanMapper dozer() {
        return new DozerBeanMapper();
    }
}
