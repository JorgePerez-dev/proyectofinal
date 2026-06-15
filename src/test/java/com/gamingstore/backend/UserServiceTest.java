package com.gamingstore.backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.gamingstore.backend.entity.User;
import com.gamingstore.backend.repository.UserRepository;
import com.gamingstore.backend.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {

        user = new User();

        user.setId(1L);

        user.setNombre("Jorge");

        user.setEmail("jorge@gmail.com");

        user.setPassword("1234");

        user.setRole("USER");
    }

    /*
     * =====================================
     * TEST BUSCAR USUARIO POR EMAIL
     * =====================================
     */
    @Test
    void testFindByEmail() {

        when(userRepository.findByEmail(
                "jorge@gmail.com"))
                .thenReturn(Optional.of(user));

        Optional<User> resultado =
                userRepository.findByEmail(
                        "jorge@gmail.com");

        assertTrue(resultado.isPresent());

        assertEquals(
                "jorge@gmail.com",
                resultado.get().getEmail());
    }

    /*
     * =====================================
     * TEST GUAR USUARIOARD
     * =====================================
     */
    @Test
    void testSaveUser() {

        when(userRepository.save(user))
                .thenReturn(user);

        User savedUser =
                userRepository.save(user);

        assertNotNull(savedUser);

        assertEquals(
                "Jorge",
                savedUser.getNombre());
    }

    /*
    
     */
    @Test
    void testUserRole() {

        assertEquals(
                "USER",
                user.getRole());
    }

    /*
     * =====================================
     * TEST PASSWORD
     * =====================================
     */
    @Test
    void testPassword() {

        assertEquals(
                "1234",
                user.getPassword());
    }
}