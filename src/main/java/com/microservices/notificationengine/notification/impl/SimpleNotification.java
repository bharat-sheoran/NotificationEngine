package com.microservices.notificationengine.notification.impl;

import java.util.Collections;
import java.util.Set;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationChannel;
import com.microservices.notificationengine.notification.NotificationRecipient;

public class SimpleNotification implements INotification {
    private String content;
    private final NotificationRecipient recipient;
    private final Set<NotificationChannel> channels;

    public SimpleNotification(String content, NotificationRecipient recipient, Set<NotificationChannel> channels) {
        this.content = content;
        this.recipient = recipient;
        this.channels = channels == null ? Collections.emptySet() : channels;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public NotificationRecipient getRecipient() {
        return this.recipient;
    }

    @Override
    public Set<NotificationChannel> getChannels() {
        return channels;
    }
}