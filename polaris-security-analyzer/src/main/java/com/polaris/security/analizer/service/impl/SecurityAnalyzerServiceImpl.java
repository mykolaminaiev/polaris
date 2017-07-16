package com.polaris.security.analizer.service.impl;

import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.Instance;
import com.polaris.security.analizer.service.SecurityAnalyzerService;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Serhii on 15.05.2016.
 */
@Service
public class SecurityAnalyzerServiceImpl implements SecurityAnalyzerService {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityAnalyzerServiceImpl.class);

    @Override
    public Map<String, List<Instance>> findVulnerabilityInstances(AwsAccount account, Interval interval) {

        return null;
    }
}
