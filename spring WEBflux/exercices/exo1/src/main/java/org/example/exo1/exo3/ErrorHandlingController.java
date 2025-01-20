package org.example.exo1.exo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ErrorHandlingController {

    @GetMapping("/error-resume")
    public Flux<String> getErrorResumeUsingMap() {
        return Flux.just(" A", " B", " C")
                .map(value -> {
                    if("C".equals(value)) {
                        throw new RuntimeException("Erreur simuler !!!");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just(" Default 1 ", " Default 2 "));


    }

    @GetMapping("/error-continue")
    public Flux<Integer> getErrorContinue() {
        return  Flux.range(1,5)
                //Simule une erreur pour le nombre 2.
                .map( n ->{
                    if (n == 2 ){
                        throw new RuntimeException("Simulated Error for number " + n);
                    }
                    return n;
                })
                //Ignore l’erreur et continue avec les autres valeurs.
                .onErrorContinue((e,value) ->{
                    System.out.println("Error ocurred for value:  " + value + " -> : " + e.getMessage() );
                });

    }

}
