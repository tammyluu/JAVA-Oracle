package org.example.libraryaop;


import org.example.libraryaop.annotation.Performance;
import org.example.libraryaop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) {


        bookService.addBook(1, "Java Oracle 21");
        bookService.addBook(2, "Spring Framework 6");

        try {
            System.out.println("Your book is added : " + bookService.getBook(1));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            //bookService.removeBook(3);
            bookService.removeBook(1);
            bookService.getBook(1);
        } catch (Exception e) {
            System.out.println("Error after deletion: " + e.getMessage());
        }
       /* System.out.println("\nAdding 10 more books...");
        long startAddTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            bookService.addBook(i, "Book " + i);
        }
        long endAddTime = System.currentTimeMillis();
        System.out.println("Time to add 10 books: " + (endAddTime - startAddTime) + " ms");*/
    }



}
