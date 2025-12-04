package com.microservices.notificationengine.notification;


public abstract class NotificationDecorator implements INotification {
    protected INotification notification;

    public NotificationDecorator(INotification n) {
        this.notification = n;
    }
}
