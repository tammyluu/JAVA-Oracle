package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        Collections.addAll(
                books,
                new Book("La colère", "Thich Nhat Hanh"),
                new Book("L'Alchimiste", "Paulo Coelho"),
                new Book("Ho'oponopono", "Luc Bodin")
        );
       SerializationBook.runSerialization(books);
       List<Book> deserializationBooks = DeserializationBook.runDeserializationBook();
       //DeserializationBook.runDeserializationBook();
        if (deserializationBooks != null) {
            System.out.println("\nBooks deserialized successfully ");

        }
        for (Book book : deserializationBooks) {
            System.out.println(book);
        }
    }
}