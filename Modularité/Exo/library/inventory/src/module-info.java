module inventory {
    requires transitive bookapi;

    exports com.inventory;
    opens com.inventory;
}