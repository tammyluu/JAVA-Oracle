package org.example.exo8.service;

import org.example.exo8.entity.Order;
import org.example.exo8.entity.OrderStatus;
import org.example.exo8.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private  final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }
    public Mono<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Flux<Order> findByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Flux<Order> findByCustomerName(String name) {
        return orderRepository.findByCustomerNameIsContainingIgnoreCase(name);
    }

    public Flux<Order> getPageOrders(int page, int size) {
        return orderRepository.findAll()
                .skip((long) page * size)
                .take(size);
    }

    public Mono<Order> save(Order order) {
        //par défaut Pending
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Mono<Order> updateOrderStatusPending(Long id, OrderStatus newStatus) {
        return orderRepository.findById(id)
                .flatMap(existingOrder ->{
                    existingOrder.setStatus(newStatus);
                    return orderRepository.save(existingOrder);
                });
    }
    public Mono<Void> deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }

}
