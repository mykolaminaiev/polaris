package com.polaris.common.service.impl;

import com.polaris.common.repository.AuditRepository;
import com.polaris.common.service.AuditService;
import com.polaris.persistence.entity.User;
import com.polaris.persistence.entity.audit.AuditEvent;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Serhii on 15.05.2016.
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void logEvent(AuditEvent event) {
        auditRepository.save(event);
    }

    @Override
    public List<AuditEvent> latestLogs(User user, Interval interval) {
        return auditRepository.findByUserAndCreationDateBetween(user, interval.getStart(), interval.getEnd());
    }
}
