package com.polaris.ui.config;

import com.polaris.aws.config.AwsIntegrationConfiguration;
import com.polaris.common.config.CommonServicesConfiguration;
import com.polaris.common.config.security.SecurityConfiguration;
import com.polaris.config.config.AbstractConfiguration;
import com.polaris.config.config.MongoConfiguration;
import com.polaris.management.config.ManagementConfiguration;
import com.polaris.persistence.config.PersistenceConfiguration;
import com.polaris.security.analizer.config.SecurityAnalyzerConfiguration;
import com.polaris.ui.config.servlet.WebAppConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                AbstractConfiguration.class,
                MongoConfiguration.class,
                PersistenceConfiguration.class,
                SecurityAnalyzerConfiguration.class,
                SecurityConfiguration.class,
                CommonServicesConfiguration.class,
                AwsIntegrationConfiguration.class,
                ManagementConfiguration.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }
}
