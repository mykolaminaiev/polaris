package com.polaris.persistence.entity.audit;

import com.polaris.persistence.entity.User;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by Serhii on 15.05.2016.
 */
@Entity
public class AuditEvent {

    @Id
    private String id;

    @Embedded
    private User user;

    @Column(name = "creation_date")
    private DateTime creationDate;

    @Embedded
    private AuditEventData data;

    public void setCreationDate() {
        creationDate = DateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }


    public AuditEventData getData() {
        return data;
    }

    public void setData(AuditEventData data) {
        this.data = data;
    }
}
