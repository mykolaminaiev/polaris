package com.polaris.management.service;

import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import com.polaris.persistence.entity.audit.AuditEvent;

import java.security.Principal;
import java.util.List;

/**
 * Created by Serhii on 14.05.2016.
 */
public interface ConsoleManagementService {

    AwsCloudTrailConfiguration getSecurityConfiguration(Principal principal);

    List<AuditEvent> listLatestLogs(Principal principal);

    void refresh(Principal principal);
}
