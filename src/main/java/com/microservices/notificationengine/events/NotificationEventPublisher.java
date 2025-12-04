package com.microservices.notificationengine.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;

@Component
public class NotificationEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public NotificationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishNotification(INotification notification) {
        NotificationCreatedEvent event = new NotificationCreatedEvent(notification);
        eventPublisher.publishEvent(event);
    }
}
