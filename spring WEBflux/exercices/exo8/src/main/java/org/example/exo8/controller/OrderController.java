package org.example.exo8.controller;

import org.example.exo8.entity.Order;
import org.example.exo8.entity.OrderStatus;
import org.example.exo8.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Order>> getOrderById(@PathVariable Long id) {
        return orderService.findById(id)
                .map(order -> ResponseEntity.ok().body(order))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping("/search")
    public Flux<Order> searchOrdersByStatus(@RequestParam OrderStatus status) {
        return  orderService.findByStatus(status);

    }

    @GetMapping("/customer/{customerName}")
    public Flux<Order> searchOrdersByCustomerName(@PathVariable String customerName) {
        return orderService.findByCustomerName(customerName);

    }

    @GetMapping("/paged")
    public Flux<ResponseEntity<Order>> getPagedOrders(@RequestParam int page, @RequestParam int size) {
        return orderService.getPageOrders(page,size)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    public Mono<ResponseEntity<Order>> addOrder(@RequestBody Order order) {
        return orderService.save(order)
                .map(createOrder -> ResponseEntity.ok().body(createOrder));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Order>> updateOrderStatus(@PathVariable Long id, @RequestBody String rawStatus) {
        try {

            String status = rawStatus.replace("\"", "").trim();

            // Convertir la chaîne en OrderStatus
            OrderStatus newStatus = OrderStatus.valueOf(status.toUpperCase());

            return orderService.updateOrderStatusPending(id, newStatus)
                    .map(ResponseEntity::ok)
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return Mono.just(ResponseEntity.badRequest().build());
        }
    }



    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id)
                .then(Mono.just(ResponseEntity.ok().build()));

    }
}
