package com.microservices.notificationengine.observers.impl;

import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.observers.AbstractObserver;

@Component
public class NotificationLogger extends AbstractObserver {
    @Override
    public void update(INotification notification) {
        System.out.println("Logging New Notification" + notification.getContent());
    }
}
