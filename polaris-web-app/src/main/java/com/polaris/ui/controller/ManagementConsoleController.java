package com.polaris.ui.controller;

import com.polaris.management.service.ConsoleManagementService;
import com.polaris.persistence.entity.AwsCloudTrailConfiguration;
import com.polaris.persistence.entity.audit.AuditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by Serhii_Nosko on 2015.
 */
@RestController
public class ManagementConsoleController {

    @Autowired
    private ConsoleManagementService managementService;

    @RequestMapping(value = "/logs")
    public List<AuditEvent> getLogs(Principal principal) {
        return managementService.listLatestLogs(principal);
    }

    @RequestMapping(value = "/settings")
    public AwsCloudTrailConfiguration getConfiguration(Principal principal) {
        return managementService.getSecurityConfiguration(principal);
    }

    @RequestMapping(value = "/refresh")
    public void refresh(Principal principal) {
        managementService.refresh(principal);
    }
}
