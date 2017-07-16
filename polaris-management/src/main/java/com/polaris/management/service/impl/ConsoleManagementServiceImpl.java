package com.polaris.management.service.impl;

import com.polaris.aws.service.AwsAnalyticsService;
import com.polaris.aws.service.AwsCloudTrailService;
import com.polaris.common.service.AuditService;
import com.polaris.common.service.UserService;
import com.polaris.management.service.ConsoleManagementService;
import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import com.polaris.persistence.entity.User;
import com.polaris.persistence.entity.audit.AuditEvent;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.security.Principal;
import java.util.List;

/**
 * Created by Serhii on 14.05.2016.
 */
@Service
public class ConsoleManagementServiceImpl implements ConsoleManagementService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleManagementServiceImpl.class);
    private static final int LOG_HISTORY_IN_DAYS = 7;

    @Autowired
    private UserService userService;

    @Autowired
    private AwsCloudTrailService cloudTrailService;

    @Autowired
    private AwsAnalyticsService analyticsService;

    @Autowired
    private AuditService auditService;

    @Override
    public AwsCloudTrailConfiguration getSecurityConfiguration(Principal principal) {
        Assert.notNull(principal, "Principal is null");

        User user = userService.findByName(principal.getName());
        Assert.notNull(user, "User is null");

        return user.getAwsAccount().getCloudTrailConfiguration();
    }

    @Override
    public List<AuditEvent> listLatestLogs(Principal principal) {
        Assert.notNull(principal, "Principal is null");

        User user = userService.findByName(principal.getName());
        Assert.notNull(user, "User is null");

        DateTime now = DateTime.now();
        DateTime before = now.minusDays(LOG_HISTORY_IN_DAYS);
        Interval interval = new Interval(before, now);
        return auditService.latestLogs(user, interval);
    }

    @Override
    public void refresh(Principal principal) {
        Assert.notNull(principal, "Principal is null");

        User user = userService.findByName(principal.getName());
        Assert.notNull(user, "User is null");

        analyticsService.processLatestLogs(user.getAwsAccount());
    }
}
