package com.microservices.notificationengine.api.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.notificationengine.api.dto.NotificationRequest;
import com.microservices.notificationengine.notification.INotification;
import com.microservices.notificationengine.notification.NotificationRecipient;
import com.microservices.notificationengine.notification.impl.SimpleNotification;
import com.microservices.notificationengine.notification.impl.TimeStampDecorator;
import com.microservices.notificationengine.services.NotificationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // POST /api/notifications
    @PostMapping
    public Mono<ResponseEntity<Void>> sendNotification(@RequestBody Mono<NotificationRequest> requestMono) {
        return requestMono
                .map(this::buildNotificationFromRequest)
                .doOnNext(notificationService::sendNotification)
                .then(Mono.just(ResponseEntity.accepted().build()));
    }

    // GET /api/notifications
    @GetMapping
    public Flux<String> getNotifications() {
        return Flux.fromIterable(notificationService.getNotifications())
                .map(INotification::getContent);
    }

    private INotification buildNotificationFromRequest(NotificationRequest request) {
        NotificationRecipient recipient = new NotificationRecipient(request.getEmail(), request.getMobile());

        INotification notification = new SimpleNotification(request.getMessage(), recipient, request.getChannels());

        if (request.isAddTimestamp()) {
            notification = new TimeStampDecorator(notification);
        }

        return notification;
    }
}
