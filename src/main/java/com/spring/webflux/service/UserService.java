package com.spring.webflux.service;

import com.spring.webflux.repository.UserRepository;
import com.spring.webflux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public Mono<User> createUser(User user) {

        return userRepository.save(user);
    }

    public Mono<User> updateUser(Long id, User user) {

        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());

                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> deleteUser(Long id){

        return userRepository.deleteById(id);
    }

}