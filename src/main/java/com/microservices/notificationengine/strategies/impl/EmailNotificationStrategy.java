package com.microservices.notificationengine.strategies.impl;

import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;
import com.microservices.notificationengine.strategies.INotificationStrategy;

@Component
public class EmailNotificationStrategy implements INotificationStrategy {

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }

    @Override
    public void sendNotification(INotification n) {
        String email = n.getRecipient() != null ? n.getRecipient().getEmail() : null;
        if (email == null || email.isBlank()) {
            // No email → nothing to do
            return;
        }
        System.out.println("Sending Email Notification to: " + email + "\n" + n.getContent());
    }
}
