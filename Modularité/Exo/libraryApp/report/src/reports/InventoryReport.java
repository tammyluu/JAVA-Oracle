package reports;
import book.Book;
import inventory.BookInventory;




public class InventoryReport {

    public void generateReport(BookInventory inventory) {
        System.out.println("Inventory Report: ");
        for (Book book : inventory.getBooks()) {
            System.out.println(book);
        }

    }
}
