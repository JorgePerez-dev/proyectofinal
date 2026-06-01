package com.gamingstore.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingstore.backend.entity.User;
import com.gamingstore.backend.repository.UserRepository;

/*
 * Service de usuarios
 * 
 * Aquí irá la lógica:
 * - registro
 * - login
 * - CRUD usuarios
 */

@Service
public class UserService {

    // Conectamos automáticamente con UserRepository
    @Autowired
    private UserRepository userRepository;

    /*
     * Obtener todos los usuarios
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /*
     * Obtener usuario por id
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /*
     * Crear usuario
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /*
     * Eliminar usuario
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /*
     * Buscar usuario por email
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}