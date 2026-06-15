package com.gamingstore.backend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoginRequestTest {

    @Test
    void testLoginRequest() {

        // Crear un objeto LoginRequest
        LoginRequest login = new LoginRequest();

        // Asignar valores
        login.setEmail("user@gmail.com");
        login.setPassword("1234");

        // Comprobar que los valores se guardan correctamente
        assertEquals("user@gmail.com", login.getEmail());
        assertEquals("1234", login.getPassword());
    }
}