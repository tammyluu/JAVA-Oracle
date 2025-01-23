package org.example.demo_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/test")
public class ReactiveController {

    @GetMapping("/single")
    public Mono<String> getSingle() {
        return Mono.just("Hello World !");
    }

    @GetMapping("/stream")
    public Flux<Integer> getStream() {
        return Flux.just(1, 2, 3,4);
    }
}