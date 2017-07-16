package com.polaris.security.analizer.service;

import com.polaris.persistence.entity.AwsAccount;
import com.polaris.persistence.entity.Instance;
import org.joda.time.Interval;

import java.util.List;
import java.util.Map;

/**
 * Created by Serhii on 09.05.2016.
 */
public interface SecurityAnalyzerService {

    Map<String/*group name*/, List<Instance>> findVulnerabilityInstances(AwsAccount account, Interval interval);
}
