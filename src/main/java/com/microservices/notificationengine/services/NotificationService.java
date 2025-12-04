package com.microservices.notificationengine.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.microservices.notificationengine.events.NotificationCreatedEvent;
import com.microservices.notificationengine.notification.INotification;

@Service
public class NotificationService {
    private final ApplicationEventPublisher eventPublisher;
    private final List<INotification> notifications = new ArrayList<>();

    public NotificationService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void sendNotification(INotification notification) {
        // 1. store notification in memory (for now – later you can persist to DB)
        notifications.add(notification);

        NotificationCreatedEvent event = new NotificationCreatedEvent(notification);
        eventPublisher.publishEvent(event);
    }

    public List<INotification> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }
}
