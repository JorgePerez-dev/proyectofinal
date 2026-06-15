
package com.gamingstore.backend.controller;

// Importamos List para devolver listas de usuarios.
import java.util.List;

// Permite inyectar automáticamente dependencias de Spring.
import org.springframework.beans.factory.annotation.Autowired;

// Importamos las anotaciones REST de Spring.
import org.springframework.web.bind.annotation.*;

// Importamos la entidad User.
import com.gamingstore.backend.entity.User;

// Importamos el servicio de usuarios.
import com.gamingstore.backend.service.UserService;

// Controlador REST encargado de gestionar usuarios.
@RestController

// Ruta base para todos los endpoints de usuarios.
@RequestMapping("/api/users")

// Permite peticiones desde el frontend.
@CrossOrigin("*")
public class UserController {

    // Inyectamos automáticamente el servicio de usuarios.
    @Autowired
    private UserService userService;

    /*
     * =====================================
     * OBTENER TODOS LOS USUARIOS
     * =====================================
     */

    // Endpoint para obtener todos los usuarios.
    @GetMapping
    public List<User> getAllUsers() {

        // Devuelve todos los usuarios desde el servicio.
        return userService.getAllUsers();
    }

    /*
     * =====================================
     * OBTENER USUARIO POR ID
     * =====================================
     */

    // Endpoint para obtener un usuario por su ID.
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        // Busca y devuelve un usuario usando su ID.
        return userService.getUserById(id);
    }

    /*
     * =====================================
     * CREAR USUARIO
     * =====================================
     */

    // Endpoint para crear un nuevo usuario.
    @PostMapping
    public User createUser(@RequestBody User user) {

        // Guarda el usuario recibido desde el frontend.
        return userService.createUser(user);
    }

    /*
     * =====================================
     * ELIMINAR USUARIO
     * =====================================
     */

    // Endpoint para eliminar un usuario por ID.
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        // Elimina el usuario usando el servicio.
        userService.deleteUser(id);
    }
}

