package com.gamingstore.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamingstore.backend.dto.LoginRequest;
import com.gamingstore.backend.entity.User;
import com.gamingstore.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    /*
     * =====================================
     * LOGIN
     * =====================================
     */
    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        /*
         * Buscar usuario por email
         */
        Optional<User> optionalUser =
                userRepository.findByEmail(
                        request.getEmail());

        /*
         * Usuario no existe
         */
        if (optionalUser.isEmpty()) {

            return "Usuario no encontrado";
        }

        /*
         * Obtener usuario
         */
        User user = optionalUser.get();

        /*
         * Comprobar contraseña
         */
        if (!user.getPassword()
                .equals(request.getPassword())) {

            return "Password incorrecta";
        }

        /*
         * Si es ADMIN
         */
        if ("ADMIN".equals(user.getRole())) {

            return "LOGIN ADMIN";
        }

        /*
         * Si es USER
         */
        return "LOGIN USER";
    }

    /*
     * =====================================
     * REGISTER
     * =====================================
     */
    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        /*
         * Verificar email repetido
         */
        if (userRepository
                .findByEmail(user.getEmail())
                .isPresent()) {

            return "El email ya existe";
        }

        /*
         * DEBUG
         */
        System.out.println(
                "EMAIL = " + user.getEmail());

        System.out.println(
                "ROLE ANTES = " + user.getRole());

        /*
         * Asignar rol USER
         */
        user.setRole("USER");

        System.out.println(
                "ROLE DESPUES = " + user.getRole());

        /*
         * Guardar usuario
         */
        userRepository.save(user);

        return "Usuario registrado correctamente";
    }
}