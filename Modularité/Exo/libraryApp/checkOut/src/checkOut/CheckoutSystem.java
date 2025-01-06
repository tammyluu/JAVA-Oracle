package checkOut;

import book.Book;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSystem {
    private Map<String, Book> checkedOutBooks = new HashMap<>();



    public boolean checkoutBook(Book book) {
        if (!checkedOutBooks.containsKey(book.getId())) {
            checkedOutBooks.put(book.getId(), book);
            System.out.println("Checked out: " + book);
            return true;
        }
        System.out.println("Book is already checked out: " + book);
        return false;
    }

    public boolean returnBook(String bookId) {
        if (checkedOutBooks.containsKey(bookId)) {
            Book book = checkedOutBooks.remove(bookId);
            System.out.println("Returned: " + book);
            return true;
        }
        System.out.println("Book not found in checked-out list.");
        return false;
    }
}
