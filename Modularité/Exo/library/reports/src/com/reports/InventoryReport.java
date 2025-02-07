package com.reports;

import com.inventory.BookInventory;

public class InventoryReport {
    public void generateReport(){
        BookInventory bookInventory = new BookInventory();
        bookInventory.listBooks().forEach(System.out::println);
    }
}
