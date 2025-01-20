package org.example.exo1.exo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class OperationController {
    @GetMapping("/processed-numbers")
    public Flux<String> getProcessedNumbers() {
        return Flux.range(1, 10)
                .filter(n -> n % 2 == 0 )
                .map(n -> n * 10)
                .map(numbers -> " Processed: " + numbers);

    }



}
