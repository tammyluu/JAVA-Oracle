package com.emailnotification;

import com.notificationservice.NotificationService;

public class EmailNotification implements NotificationService {
    @Override
    public String getName() {
        return "Email";
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Envoie d'un email avec le message : "+message);
    }
}
