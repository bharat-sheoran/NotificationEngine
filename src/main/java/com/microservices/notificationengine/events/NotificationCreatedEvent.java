package com.microservices.notificationengine.events;

import com.microservices.notificationengine.notification.INotification;

public class NotificationCreatedEvent {
    private final INotification notification;

    public NotificationCreatedEvent(INotification notification) {
        this.notification = notification;
    }

    public INotification getNotification() {
        return notification;
    }

    public String getNotificationContent() {
        return notification.getContent();
    }
}
