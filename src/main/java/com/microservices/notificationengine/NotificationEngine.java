package com.microservices.notificationengine;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.observers.AbstractObserver;
import com.microservices.notificationengine.strategies.INotificationStrategy;

@Component
public class NotificationEngine extends AbstractObserver {

    private final List<INotificationStrategy> notificationStrategies;

    public NotificationEngine(List<INotificationStrategy> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    @Override
    public void update(INotification notification) {
        var channels = notification.getChannels();
        boolean allChannels = (channels == null || channels.isEmpty());

        for (INotificationStrategy strategy : notificationStrategies) {
            if (allChannels || channels.contains(strategy.getChannel())) {
                strategy.sendNotification(notification);
            }
        }
    }
}
