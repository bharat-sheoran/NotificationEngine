package com.microservices.notificationengine.strategies;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;

public interface INotificationStrategy {
    public void sendNotification(INotification n);
    NotificationChannel getChannel();
}
