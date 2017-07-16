package com.polaris.aws.config;

import com.google.common.collect.Lists;
import com.polaris.aws.model.EventType;
import com.polaris.aws.model.StandardAwsService;
import com.polaris.aws.model.StandardAwsServiceGroup;
import com.polaris.aws.service.AwsServiceEventProvider;
import com.polaris.aws.service.AwsServiceGroupProvider;
import com.polaris.aws.service.AwsServiceProvider;
import com.polaris.persistence.entity.AwsService;
import com.polaris.persistence.entity.AwsServiceEvent;
import com.polaris.persistence.entity.AwsServicesGroup;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii on 28.05.2016.
 */
@Service
public class AwsIntegrationAutoConfigurationService {

    @Autowired
    private AwsServiceGroupProvider groupService;

    @Autowired
    private AwsServiceProvider awsServiceProvider;

    @Autowired
    private AwsServiceEventProvider awsServiceEventProvider;

    @PostConstruct
    public void init() {
        Arrays.stream(StandardAwsServiceGroup.values()).forEach(this::saveOrUpdateGroup);

        Lists.newArrayList(groupService.findAll()).stream()
                .filter(group -> StandardAwsServiceGroup.fromName(group.getName()) == null)
                .forEach(group -> groupService.delete(group));
    }

    private void saveOrUpdateGroup(StandardAwsServiceGroup type) {
        AwsServicesGroup group = ObjectUtils.defaultIfNull(
                groupService.findByName(
                        type.name()
                ),
                new AwsServicesGroup(type.name())
        );
        List<StandardAwsService> standardServices = StandardAwsService.getServiceTypes(type);
        List<AwsService> services = saveOrUpdateService(standardServices);
        awsServiceProvider.saveOrUpdate(services);
        group.setServices(services);
        groupService.saveOrUpdate(group);
    }

    private List<AwsService> saveOrUpdateService(List<StandardAwsService> standardServices) {
        List<AwsService> services = new ArrayList<>();
        for (StandardAwsService standardService : standardServices) {
            AwsService service = ObjectUtils.defaultIfNull(
                    awsServiceProvider.findByName(
                            standardService.name()
                    ),
                    new AwsService(standardService.name())
            );
            List<EventType> eventTypes = EventType.getEventTypes(standardService);
            service.setEvents(saveOrUpdateServiceEvent(eventTypes));
            services.add(service);
        }
        return services;
    }

    private List<AwsServiceEvent> saveOrUpdateServiceEvent(List<EventType> eventTypes) {
        List<AwsServiceEvent> events = new ArrayList<>();
        for (EventType eventType : eventTypes) {
            AwsServiceEvent event = ObjectUtils.defaultIfNull(
                    awsServiceEventProvider.findByName(
                            eventType.getEventName()
                    ),
                    new AwsServiceEvent(eventType.getEventName())
            );
            events.add(event);
        }
        awsServiceEventProvider.saveOrUpdate(events);
        return events;
    }
}
