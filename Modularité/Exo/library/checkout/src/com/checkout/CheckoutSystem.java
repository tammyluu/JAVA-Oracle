package com.checkout;

import com.inventory.BookInventory;

import com.bookapi.Book;
import com.notificationservice.NotificationService;

import java.util.ServiceLoader;

public class CheckoutSystem {
    public void checkoutBook(String title){
        BookInventory inventory = new BookInventory();
        Book book = inventory.listBooks().stream().filter(b -> b.title().equals(title)).findFirst().orElse(null);
        if(book != null){
            System.out.println("Livre trouve "+book);
            NotificationService notificationService = ServiceLoader.load(NotificationService.class) // Chargement des implementations de NotificationService
                    .stream() // Transformation en flux
                    .map(ServiceLoader.Provider::get) // Extraction des implementations
                    .filter(service -> service.getName().equals("Email")) // Filtrage pour selectionner l'implementation "Email"
                    .findFirst() // Recherche du premier service correspondant
                    .orElseThrow(); // Lance une exception si aucun service "Email"
            notificationService.sendNotification("Vous avez trouvez le livre "+book.title());

        }else {
            System.out.println("Livre non disponible");
        }
    }
}
