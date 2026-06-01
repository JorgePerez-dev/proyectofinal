package com.gamingstore.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gamingstore.backend.entity.Product;
import com.gamingstore.backend.entity.User;
import com.gamingstore.backend.repository.ProductRepository;
import com.gamingstore.backend.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            ProductRepository productRepository,
            UserRepository userRepository) {

        return args -> {

            /*
             * SOLO SI LA BD ESTÁ VACÍA
             */
            if (userRepository.count() == 0) {

                // =====================================
                // PRODUCTO
                // =====================================

                Product p1 = new Product();

                p1.setNombre("PlayStation 5");

                p1.setDescripcion("Consola Sony");

                p1.setPrecio(499.99);

                p1.setStock(10);

                p1.setCategoria("Consolas");

                productRepository.save(p1);



                // =====================================
                // ADMIN
                // =====================================

                User admin = new User();

                admin.setNombre("Administrador");

                admin.setEmail("admin@gmail.com");

                /*
                 * PASSWORD NORMAL
                 */
                admin.setPassword("1234");

                admin.setRole("ADMIN");

                userRepository.save(admin);



                // =====================================
                // USER
                // =====================================

                User user = new User();

                user.setNombre("Usuario");

                user.setEmail("user@gmail.com");

                /*
                 * PASSWORD NORMAL
                 */
                user.setPassword("1234");

                user.setRole("USER");

                userRepository.save(user);



                // =====================================
                // MENSAJE CONSOLA
                // =====================================

                System.out.println(
                    "Datos insertados correctamente"
                );
            }
        };
    }
}