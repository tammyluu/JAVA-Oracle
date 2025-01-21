package org.example.exo7.service;

import org.example.exo7.entity.User;
import org.example.exo7.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Flux<User> findAll() {
        return userRepository.findAll();
    }
    public Mono<User> getById(int id) {
        return userRepository.findById(id);
    }
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
    public Mono<Void> deleteById(int id) {
        return userRepository.deleteById(id);
    }
    public Mono<User> update(int id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser ->{
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setActive(user.isActive());
                    return userRepository.save(existingUser);
                });

    }

}
