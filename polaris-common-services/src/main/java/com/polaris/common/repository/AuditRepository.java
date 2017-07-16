package com.polaris.common.repository;

import com.polaris.persistence.entity.User;
import com.polaris.persistence.entity.audit.AuditEvent;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Serhii on 15.05.2016.
 */
public interface AuditRepository extends MongoRepository<AuditEvent, String> {

    List<AuditEvent> findByUserAndCreationDateBetween(User user, DateTime start, DateTime end);
}
