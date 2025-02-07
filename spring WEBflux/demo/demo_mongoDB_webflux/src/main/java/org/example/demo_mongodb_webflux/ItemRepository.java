package org.example.demo_mongodb_webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


public interface ItemRepository extends ReactiveMongoRepository<Item, String> {

    //trouver par nom
    Flux<Item> findByName(String name);
}
