package org.example.exo1.exo6;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BookService {

    private final Map<String, Book> books = new HashMap<>();

    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(books.values());
    }
    public Flux<Book> searchBooksByTitle(String title) {
        return Flux.fromStream(books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())));
    }

    public Mono<Book> addBook(Book book) {
        UUID uuid = UUID.randomUUID();
        book.setId(uuid);
        books.put(uuid.toString(), book);
        return Mono.just(book);

    }
   public Mono<Void> deleteBook(String id) {
        books.remove(id);
        return Mono.empty();
   }
}
