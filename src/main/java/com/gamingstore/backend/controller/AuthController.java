
package com.gamingstore.backend.controller;

// Importamos Optional para manejar si un usuario existe o no.
import java.util.Optional;

// Permite inyectar automáticamente dependencias de Spring.
import org.springframework.beans.factory.annotation.Autowired;

// Importamos anotaciones para crear endpoints REST.
import org.springframework.web.bind.annotation.*;

// DTO que recibe los datos del login.
import com.gamingstore.backend.dto.LoginRequest;

// Entidad que representa un usuario.
import com.gamingstore.backend.entity.User;

// Repositorio para acceder a la tabla de usuarios.
import com.gamingstore.backend.repository.UserRepository;

// Indica que esta clase es un controlador REST.
@RestController

// Ruta base para los endpoints de autenticación.
@RequestMapping("/api/auth")

// Permite peticiones desde el frontend.
@CrossOrigin("*")
public class AuthController {

    // Inyectamos el repositorio de usuarios.
    @Autowired
    private UserRepository userRepository;

    /*
     * =====================================
     * LOGIN
     * =====================================
     */

    // Endpoint para iniciar sesión.
    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        // Buscar usuario en la base de datos por email.
        Optional<User> optionalUser =
                userRepository.findByEmail(
                        request.getEmail());

        // Si el usuario no existe, devolver mensaje de error.
        if (optionalUser.isEmpty()) {

            return "Usuario no encontrado";
        }

        // Obtener el usuario encontrado.
        User user = optionalUser.get();

        // Comprobar si la contraseña es incorrecta.
        if (!user.getPassword()
                .equals(request.getPassword())) {

            return "Password incorrecta";
        }

        // Si el usuario tiene rol ADMIN, devolver login de administrador.
        if ("ADMIN".equals(user.getRole())) {

            return "LOGIN ADMIN";
        }

        // Si no es ADMIN, se considera usuario normal.
        return "LOGIN USER";
    }

    /*
     * =====================================
     * REGISTER
     * =====================================
     */

    // Endpoint para registrar un nuevo usuario.
    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        // Comprobar si ya existe un usuario con ese email.
        if (userRepository
                .findByEmail(user.getEmail())
                .isPresent()) {

            return "El email ya existe";
        }

        // Mostrar el email recibido en la consola.
        System.out.println(
                "EMAIL = " + user.getEmail());

        // Mostrar el rol antes de asignarlo.
        System.out.println(
                "ROLE ANTES = " + user.getRole());

        // Asignar rol USER a todos los usuarios registrados.
        user.setRole("USER");

        // Mostrar el rol después de asignarlo.
        System.out.println(
                "ROLE DESPUES = " + user.getRole());

        // Guardar el nuevo usuario en la base de datos.
        userRepository.save(user);

        // Devolver mensaje indicando que el registro fue correcto.
        return "Usuario registrado correctamente";
    }
}
