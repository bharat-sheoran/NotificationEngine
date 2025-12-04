package com.microservices.notificationengine.api.dto;

import java.util.Set;

import com.microservices.notificationengine.notification.NotificationChannel;

public class NotificationRequest {
    private String message;
    private boolean addTimestamp;
    private String email;
    private String mobile;
    private Set<NotificationChannel> channels;

    public NotificationRequest() {
    }

    public NotificationRequest(String message, boolean addTimestamp) {
        this.message = message;
        this.addTimestamp = addTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAddTimestamp() {
        return addTimestamp;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Set<NotificationChannel> getChannels() {
        return channels;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAddTimestamp(boolean addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setChannels(Set<NotificationChannel> channels) {
        this.channels = channels;
    }
}
