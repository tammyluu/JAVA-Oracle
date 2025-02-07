package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationBook {

    public static void runSerialization (List<Book> books) {
        System.out.println(" ----------- Serialization start ------------------ ");
        Book b = new Book("Anne Frank ", "Anne Frank");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            oos.writeObject(books);
            System.out.println(" Serialization object end. " );

        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }
    }
}
