module checkout {
    requires inventory;
    requires notificationservice;
    requires bookapi;

    exports com.checkout;

    uses com.notificationservice.NotificationService;
}