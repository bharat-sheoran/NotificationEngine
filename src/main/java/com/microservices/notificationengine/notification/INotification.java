package com.microservices.notificationengine.notification;

import java.util.Set;

public interface INotification {
    public String getContent();

    NotificationRecipient getRecipient();

    Set<NotificationChannel> getChannels();
}
