package inventory;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInventory {

    List<Book> books = new ArrayList<Book>();
    public void add(Book book) {
        books.add(book);
        System.out.println("Book added to the inventory: " + book);
    }
    public void remove(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId) );
        System.out.println("Book removed from the inventory with Id: " + bookId);
    }

    public List<Book> getBooks() {
        return books;
    }

}
