package org.example.demo_mongodb_webflux;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    public ItemController( ItemService itemService) {
        this.itemService = itemService;

    }
    @GetMapping
    public Flux<Item> getAllItems() {
        return itemService.getAll();
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Item>> getItemById(@PathVariable String id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Item> addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Item>> updateItem(@PathVariable String id,@RequestBody Item item) {
        return itemService.updateItem(id,item)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteItem(@PathVariable String id) {
        return itemService.deleteItemById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
