package com.polaris.common.service;

import com.polaris.persistence.entity.User;
import com.polaris.persistence.entity.audit.AuditEvent;
import org.joda.time.Interval;

import java.util.List;

/**
 * Created by Serhii on 15.05.2016.
 */
public interface AuditService {

    void logEvent(AuditEvent event);

    List<AuditEvent> latestLogs(User user, Interval interval);
}
