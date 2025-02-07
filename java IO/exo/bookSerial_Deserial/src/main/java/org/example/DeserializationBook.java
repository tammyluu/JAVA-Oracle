package org.example;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializationBook {
    public static List<Book> runDeserializationBook() {
        System.out.println(" ----------- Deserialization start ------------------ ");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"))) {
            Book book = (Book) ois.readObject();
            System.out.println("Deserialization object end  " +book );

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("error: " + e.getMessage());
        }
        return null;
    }
}


