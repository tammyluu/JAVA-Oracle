package org.example.exo1.exo6;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Locale;
import java.util.UUID;

@Component
public class BookHandler {

    private final BookService bookService;
    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }
    public Mono<ServerResponse> addBook(ServerRequest request) {
        return request.bodyToMono(Book.class)
                .flatMap(bookService::addBook)
                .flatMap(book -> ServerResponse.ok().bodyValue(book));
    }
    public Mono<ServerResponse> getAllBooks(ServerRequest request) {
        return ServerResponse.ok().body(bookService.getAllBooks(), Book.class);
    }

    public Mono<ServerResponse> getBookByTitle(ServerRequest request) {
        String title = request.queryParam("title").orElse("");
                return ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(bookService.searchBooksByTitle(title), Book.class);
    }
    public Mono<ServerResponse> deleteBook(ServerRequest request) {
        String id = request.pathVariable("id");
                return bookService.deleteBook(id)
                        .then(ServerResponse.noContent().build());
    }




}
