package com.microservices.notificationengine.observers;

import com.microservices.notificationengine.notification.INotification;

public interface IObserver {
    public void update(INotification notification);
}
