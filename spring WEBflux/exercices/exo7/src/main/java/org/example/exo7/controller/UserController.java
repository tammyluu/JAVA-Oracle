package org.example.exo7.controller;

import org.example.exo7.entity.User;
import org.example.exo7.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping
    public Flux<User> getUsers() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public Mono<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

     @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable int id) {
        return userService.deleteById(id);
     }

}
