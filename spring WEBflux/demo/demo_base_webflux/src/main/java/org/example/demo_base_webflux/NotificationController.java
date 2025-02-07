package org.example.demo_base_webflux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public Flux<Notification> getNotifications() {
        return notificationService.getNotifications();
    }

    @GetMapping("/urgence")
    public Flux<Notification> getUrgences() {
        return notificationService.getFilterNotifications();
    }

    @GetMapping(value = "notiftexte", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getNotiftexte() {
        return notificationService.getFilterNotifications()
                .map(notification -> "Notification: " + notification.toString());
    }

}
