package com.microservices.notificationengine.strategies.impl;

import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;
import com.microservices.notificationengine.strategies.INotificationStrategy;

@Component
public class PopUpStrategy implements INotificationStrategy {

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.POPUP;
    }

    @Override
    public void sendNotification(INotification n) {
        System.out.println("PopUp Notification to: " + "\n" + n.getContent());
    }
}
