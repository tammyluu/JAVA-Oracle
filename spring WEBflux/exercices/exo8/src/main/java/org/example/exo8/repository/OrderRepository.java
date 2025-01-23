package org.example.exo8.repository;

import org.example.exo8.entity.Order;
import org.example.exo8.entity.OrderStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

public interface OrderRepository extends ReactiveCrudRepository<Order,Long> {

    Flux<Order> findByStatus(OrderStatus status);
    Flux<Order> findByCustomerNameIsContainingIgnoreCase(String customerName);
    Flux<Order> findAllByPageable(Pageable pageable);
}
