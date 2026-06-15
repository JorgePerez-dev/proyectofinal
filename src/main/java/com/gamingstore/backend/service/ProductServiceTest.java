package com.gamingstore.backend.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gamingstore.backend.entity.Product;

public class ProductServiceTest {

    @Test
    void testCrearProducto() {

        Product product = new Product();

        product.setId(1L);
        product.setNombre("PlayStation 5");
        product.setDescripcion("Consola Sony");
        product.setPrecio(499.99);
        product.setStock(10);
        product.setCategoria("Consolas");

        assertEquals(1L, product.getId());
        assertEquals("PlayStation 5", product.getNombre());
        assertEquals("Consola Sony", product.getDescripcion());
        assertEquals(499.99, product.getPrecio());
        assertEquals(10, product.getStock());
        assertEquals("Consolas", product.getCategoria());
    }
}