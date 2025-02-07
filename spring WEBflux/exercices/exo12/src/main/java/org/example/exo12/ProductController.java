package org.example.exo12;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/inventory")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> getProductByID(@PathVariable String id) {
        return service.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }
    @GetMapping
    public Flux<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Mono<Product> addProduct(@Valid @RequestBody Product product) {
        return service.addProduct(product);

    }

    @GetMapping("/price/{maxPrice}")
    public Flux<Product> getProductByMaxPrice(@PathVariable double maxPrice) {
        if (maxPrice <= 0) {
            return Flux.error(new IllegalArgumentException("maxPrice must be greater than 0"));
        }
        return service.getProductsByMaxPrice(maxPrice);
    }
}
