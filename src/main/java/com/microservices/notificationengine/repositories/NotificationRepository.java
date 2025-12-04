package com.microservices.notificationengine.repositories;

import com.microservices.notificationengine.notification.INotification;

public interface NotificationRepository {
    void save(INotification notification);
}