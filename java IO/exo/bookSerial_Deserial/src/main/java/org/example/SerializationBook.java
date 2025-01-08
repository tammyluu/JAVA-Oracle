package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationBook {
    public static void runSerialization () {
        System.out.println(" ----------- Serialization start ------------------ ");
        Book b = new Book("Anne Frank ", "Anne Frank");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            oos.writeObject(b);
            System.out.println(" Serialization object end : " + b);

        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }
    }
}
