package app;

import book.Book;
import checkOut.CheckoutSystem;
import emailNotification.EmailNotification;
import inventory.BookInventory;
import reports.InventoryReport;




public class LibraryApp {
    public static void main(String[] args) {

            BookInventory bookInventory = new BookInventory();
            CheckoutSystem checkoutSystem = new CheckoutSystem();
            EmailNotification emailNotification = new EmailNotification();
            InventoryReport report = new InventoryReport();

            Book b1 = new  Book("B1", "Le Journal d'Anne Frank", "Anne Frank");
            Book b2 = new Book("2", "Brave New World", "Aldous Huxley");

        checkoutSystem.checkoutBook(b1);
        checkoutSystem.returnBook(b1.getId());

        report.generateReport(bookInventory);

        emailNotification.sendEmail("user@example.com", "Your book is ready for pickup!");

    }
}
