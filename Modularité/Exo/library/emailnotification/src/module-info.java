module emailnotification {
    requires notificationservice;

    provides com.notificationservice.NotificationService with com.emailnotification.EmailNotification;
}