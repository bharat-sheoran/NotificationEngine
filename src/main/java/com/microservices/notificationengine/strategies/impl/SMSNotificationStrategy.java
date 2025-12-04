package com.microservices.notificationengine.strategies.impl;

import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;
import com.microservices.notificationengine.strategies.INotificationStrategy;

@Component
public class SMSNotificationStrategy implements INotificationStrategy {

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.SMS;
    }

    @Override
    public void sendNotification(INotification n) {
        String mobile = n.getRecipient() != null ? n.getRecipient().getMobile() : null;
        if (mobile == null || mobile.isBlank()) {
            return;
        }
        System.out.println("Sending SNS Notification to: " + mobile + "\n" + n.getContent());
    }
}
