package com.microservices.notificationengine.notification;

public class NotificationRecipient {
    private final String email;
    private final String mobile;

    public NotificationRecipient(String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

}
