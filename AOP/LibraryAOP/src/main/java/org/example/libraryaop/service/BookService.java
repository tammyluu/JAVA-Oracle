package org.example.libraryaop.service;

import org.example.libraryaop.annotation.ExceptionAnnotation;
import org.example.libraryaop.annotation.Log;
import org.example.libraryaop.annotation.Performance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Integer, String> books = new HashMap<>();

    @Log
    @Performance
    public void addBook(int id, String name) {
        books.put(id, name);
    }

    @Log
    @Performance
    @ExceptionAnnotation
    public void removeBook(int id) {
        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Cannot remove: Book not found with ID " + id);
        }
        books.remove(id);
    }

    @Log
    @Performance
    @ExceptionAnnotation
    public String getBook(int id) {
        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Book not found with ID " + id);
        }
        return books.get(id);
    }
}
