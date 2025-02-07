package org.example.exo12;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Mono<Product> getProductById(String id) {
       return productRepository.findById(id);

    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> addProduct(Product product) {
      return productRepository.save(product);
    }


    public Flux<Product> getProductsByMaxPrice(double maxPrice) {
        return productRepository.findByPriceLessThanEqual(maxPrice);
    }
}
