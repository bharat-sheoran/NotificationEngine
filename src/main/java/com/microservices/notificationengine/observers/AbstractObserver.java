package com.microservices.notificationengine.observers;

import org.springframework.context.event.EventListener;

import com.microservices.notificationengine.events.NotificationCreatedEvent;

public abstract class AbstractObserver implements IObserver {
    
    @EventListener
    public void onNotification(NotificationCreatedEvent event) {
        update(event.getNotification());
    }
}
