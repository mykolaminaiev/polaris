package com.polaris.ui.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Sets up the Spring Security filter chain
 * Created by Serhii on 26.04.2016.
 */
@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
