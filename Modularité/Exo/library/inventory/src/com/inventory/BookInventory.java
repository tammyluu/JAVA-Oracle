package com.inventory;

import com.bookapi.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInventory {

    private List<Book> books;

    public BookInventory() {
        this.books = new ArrayList<>();
        books.add(new Book("Le petit chaperon rouge"));
        books.add(new Book("Le seigneur des anneaux"));
    }

    public List<Book> listBooks() {
        return books;
    }
}
