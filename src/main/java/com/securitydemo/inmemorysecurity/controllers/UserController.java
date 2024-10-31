package com.securitydemo.inmemorysecurity.controllers;



import com.securitydemo.inmemorysecurity.entities.User;
import com.securitydemo.inmemorysecurity.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepository;
//    @Transactional
    @PostMapping
    public User createUser(@RequestBody User user) {

            return userRepository.save(user);


    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

