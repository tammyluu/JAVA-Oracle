package com.app;

import com.checkout.CheckoutSystem;
import com.reports.InventoryReport;

public class LibrayApp {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans la librairie");

        // generer un rapport
        System.out.println("Liste des livres");
        var inventoryReport = new InventoryReport();
        inventoryReport.generateReport();

        // check si livre dispo
        System.out.println("check si livre dispo");


        CheckoutSystem checkoutSystem = new CheckoutSystem();
        checkoutSystem.checkoutBook("Le petit chaperon rouge");
    }
}
