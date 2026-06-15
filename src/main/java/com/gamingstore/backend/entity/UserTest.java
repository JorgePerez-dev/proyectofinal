package com.gamingstore.backend.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testUsuario() {

        User user = new User();

        user.setNombre("Jorge");
        user.setEmail("jorge@gmail.com");
        user.setPassword("1234");
        user.setRole("USER");

        assertEquals("Jorge", user.getNombre());
        assertEquals("jorge@gmail.com", user.getEmail());
        assertEquals("1234", user.getPassword());
        assertEquals("USER", user.getRole());
    }
}