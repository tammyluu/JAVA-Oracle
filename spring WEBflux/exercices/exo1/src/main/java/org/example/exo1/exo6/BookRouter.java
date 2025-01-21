package org.example.exo1.exo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> bookRoute(BookHandler bookHandler){
        return
                route(GET("/api/books"), bookHandler::getAllBooks)
                        .andRoute(GET(("api/books/search")), bookHandler::getBookByTitle)
                        .andRoute(POST("/api/books"), bookHandler::addBook)
                        .andRoute(DELETE("/api/books/{id}"), bookHandler::deleteBook);

    }
}
