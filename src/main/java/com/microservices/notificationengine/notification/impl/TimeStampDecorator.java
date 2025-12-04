package com.microservices.notificationengine.notification.impl;

import java.util.Set;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;
import com.microservices.notificationengine.notification.NotificationDecorator;
import com.microservices.notificationengine.notification.NotificationRecipient;

public class TimeStampDecorator extends NotificationDecorator {
    public TimeStampDecorator(INotification n) {
        super(n);
    }

    @Override
    public String getContent() {
        return "[2025-04-13 14:22:00]" + notification.getContent(); // TODO: Replace with actual timestamp logic
    }

    @Override
    public NotificationRecipient getRecipient() {
        return notification.getRecipient();
    }

    @Override
    public Set<NotificationChannel> getChannels() {
        return notification.getChannels();
    }
}
