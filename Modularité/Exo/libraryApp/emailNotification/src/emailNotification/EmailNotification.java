package emailNotification;

import notificationService.NotificationService;

public class EmailNotification {

    private NotificationService notificationService = new NotificationService();

    public void sendEmail(String recipient, String message) {
        notificationService.sendNotification("Email to " + recipient + ": " + message);
    }
}
