package com.gamingstore.backend.security;

// Permite registrar métodos como beans de Spring.
import org.springframework.context.annotation.Bean;

// Indica que esta clase contiene configuración de Spring.
import org.springframework.context.annotation.Configuration;

// Permite configurar la seguridad HTTP de la aplicación.
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Define la cadena de filtros de seguridad de Spring.
import org.springframework.security.web.SecurityFilterChain;

// Clase encargada de configurar la seguridad del backend.
@Configuration
public class SecurityConfig {

// Bean que define la configuración de seguridad de Spring.
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {

    // Configuramos las reglas de seguridad HTTP.
    http

        // Desactiva CSRF para permitir peticiones desde el frontend.
        .csrf(csrf -> csrf.disable())

        // Configura los permisos de las rutas.
        .authorizeHttpRequests(auth -> auth

            // Permite acceder a cualquier endpoint sin autenticación.
            .anyRequest().permitAll()
        );

    // Construye y devuelve la configuración de seguridad.
    return http.build();
}

}
