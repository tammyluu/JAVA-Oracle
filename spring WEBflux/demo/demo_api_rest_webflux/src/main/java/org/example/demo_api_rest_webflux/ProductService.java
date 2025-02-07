package org.example.demo_api_rest_webflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {
    private final Map<String, Product> products = new HashMap<>();
    public  ProductService (){
        // produit de test
        products.put("1",new Product("1", "Livre", BigDecimal.valueOf(0.99)));
        products.put("2",new Product("2", "Tomate", BigDecimal.valueOf(14.75)));
        products.put("3",new Product("3", "Salade", BigDecimal.valueOf(0.88)));
    }

    public Flux<Product> findAll(){
        return Flux.fromIterable(products.values());
    }

    public Mono<Product> findById(String id){
        return Mono.justOrEmpty(products.get(id));
    }

    public Mono<Product> save(Product product){
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(id,product);
        return Mono.just(product);
    }
}
