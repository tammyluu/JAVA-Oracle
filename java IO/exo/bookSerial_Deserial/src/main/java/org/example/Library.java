package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final String FILE_PATH = "library.ser";
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();

    }

    private void addBook(Scanner sc) {
        System.out.println("Enter the name of the book: ");
        String title = sc.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = sc.nextLine();
        books.add(new Book(title, author));
    }

    private void diplayBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void saveLibrary() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.ser"))) {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private  void loadBooks() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                books = (List<Book>) in.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
