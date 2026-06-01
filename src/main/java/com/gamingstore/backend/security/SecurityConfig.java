package com.gamingstore.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

            // Desactivar CSRF
            .csrf(csrf -> csrf.disable())

            // Permitir TODAS las rutas
            .authorizeHttpRequests(auth -> auth

                .anyRequest().permitAll()
            );

        return http.build();
    }
}