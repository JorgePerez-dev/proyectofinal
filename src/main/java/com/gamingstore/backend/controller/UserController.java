package com.gamingstore.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamingstore.backend.entity.User;
import com.gamingstore.backend.service.UserService;

/*
 * Controller de usuarios
 * 
 * Recibe las peticiones HTTP relacionadas con usuarios.
 */

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    // Inyección automática del service
    @Autowired
    private UserService userService;

 
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}