package com.gamingstore.backend.repository;

// Importamos Optional para manejar si el usuario existe o no.
import java.util.Optional;

// JpaRepository nos da métodos CRUD automáticamente.
import org.springframework.data.jpa.repository.JpaRepository;

// Importamos la entidad User.
import com.gamingstore.backend.entity.User;

// Repositorio encargado de acceder a la tabla de usuarios.
public interface UserRepository
extends JpaRepository<User, Long> {


// Busca un usuario en la base de datos usando su email.
Optional<User> findByEmail(String email);
}
