package org.example.demo_mongodb_webflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

   public Flux<Item> getAll() {
        return itemRepository.findAll();
   }
   public Flux<Item> getByName(String name) {
        return itemRepository.findByName(name);
   }
   public Mono<Item> getItemById(String id) {
        return itemRepository.findById(id);
   }
   public Mono<Item> save(Item item) {
        return itemRepository.save(item);
   }

    public Mono<Item> updateItem(String id, Item item) {
        return itemRepository.findById(id)
                .flatMap(existingItem -> {
                    existingItem.setName(item.getName());
                    existingItem.setDescription(item.getDescription());
                    existingItem.setPrice(item.getPrice());
                    return itemRepository.save(existingItem);
                });
    }

   public Mono<Void> deleteItemById(String id) {
        return itemRepository.deleteById(id);
   }

}
