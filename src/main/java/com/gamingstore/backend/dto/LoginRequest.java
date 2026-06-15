package com.gamingstore.backend.dto;

// Clase DTO que recibe los datos enviados desde el formulario de login.
public class LoginRequest {

// Email que introduce el usuario al iniciar sesión.
private String email;

// Contraseña que introduce el usuario al iniciar sesión.
private String password;

// Constructor vacío necesario para que Spring pueda crear el objeto.
public LoginRequest() {
}

// Devuelve el email recibido desde el frontend.
public String getEmail() {
    return email;
}

// Guarda el email recibido desde el frontend.
public void setEmail(String email) {
    this.email = email;
}

// Devuelve la contraseña recibida desde el frontend.
public String getPassword() {
    return password;
}

// Guarda la contraseña recibida desde el frontend.
public void setPassword(String password) {
    this.password = password;
}

}
