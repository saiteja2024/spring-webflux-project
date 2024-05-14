package com.spring.webflux.controller;


import com.spring.webflux.model.User;
import com.spring.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Flux<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable Long id){

        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<User> updateUserById(@PathVariable Long id, @RequestBody User user ){

        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id){

        return userService.deleteUser(id);
    }
}
