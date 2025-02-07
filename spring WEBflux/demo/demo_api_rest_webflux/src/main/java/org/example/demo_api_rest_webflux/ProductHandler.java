package org.example.demo_api_rest_webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.created;

@Component
public class ProductHandler {
    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> getAllProducts(ServerRequest serverRequest) {
         return ServerResponse.ok().body(productService.findAll(), Product.class);

    }
    public Mono<ServerResponse> getProductById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return productService.findById(id)
                .flatMap(product -> ServerResponse.ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .flatMap(productService::save)
                .flatMap(product -> ServerResponse.ok().bodyValue(product));
    }

}
