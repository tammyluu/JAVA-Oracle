package org.example.exo1.exo4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @GetMapping
    public Flux<String> getArticles() {
        return Flux.just(
                "Introduction to Spring WebFlux",
                "\nReactive Programming with Project Reactor",
                "\nBuilding APIs with Spring Boot"
        );
    }
}
