
package com.gamingstore.backend.config;

// Permite ejecutar código automáticamente al arrancar Spring Boot.
import org.springframework.boot.CommandLineRunner;

// Permite registrar métodos como beans de Spring.
import org.springframework.context.annotation.Bean;

// Indica que esta clase contiene configuración de Spring.
import org.springframework.context.annotation.Configuration;

// Importamos la entidad Product.
import com.gamingstore.backend.entity.Product;

// Importamos la entidad User.
import com.gamingstore.backend.entity.User;

// Importamos el repositorio de productos.
import com.gamingstore.backend.repository.ProductRepository;

// Importamos el repositorio de usuarios.
import com.gamingstore.backend.repository.UserRepository;

// Clase que inserta datos iniciales en la base de datos.
@Configuration
public class DataLoader {

    // Bean que se ejecuta automáticamente al iniciar la aplicación.
    @Bean
    CommandLineRunner initDatabase(
            ProductRepository productRepository,
            UserRepository userRepository) {

        // Código que se ejecuta después de arrancar Spring Boot.
        return args -> {

            // Solo inserta datos si todavía no hay usuarios en la BD.
            if (userRepository.count() == 0) {

                // Crear un producto de ejemplo.
                Product p1 = new Product();

                // Asignar nombre al producto.
                p1.setNombre("PlayStation 5");

                // Asignar descripción al producto.
                p1.setDescripcion("Consola Sony");

                // Asignar precio al producto.
                p1.setPrecio(499.99);

                // Asignar stock disponible.
                p1.setStock(10);

                // Asignar categoría al producto.
                p1.setCategoria("Consolas");

                // Guardar el producto en la base de datos.
                productRepository.save(p1);

                // Crear un usuario administrador.
                User admin = new User();

                // Asignar nombre al administrador.
                admin.setNombre("Administrador");

                // Asignar email al administrador.
                admin.setEmail("admin@gmail.com");

                // Asignar contraseña al administrador.
                admin.setPassword("1234");

                // Asignar rol de administrador.
                admin.setRole("ADMIN");

                // Guardar el administrador en la base de datos.
                userRepository.save(admin);

                // Crear un usuario normal.
                User user = new User();

                // Asignar nombre al usuario.
                user.setNombre("Usuario");

                // Asignar email al usuario.
                user.setEmail("user@gmail.com");

                // Asignar contraseña al usuario.
                user.setPassword("1234");

                // Asignar rol de usuario normal.
                user.setRole("USER");

                // Guardar el usuario en la base de datos.
                userRepository.save(user);

                // Mostrar mensaje en consola.
                System.out.println(
                    "Datos insertados correctamente"
                );
            }
        };
    }
    
}

