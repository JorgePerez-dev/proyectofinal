package com.gamingstore.backend.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void testProducto() {

        Product product = new Product();

        product.setNombre("PlayStation 5");
        product.setPrecio(499.99);

        assertEquals("PlayStation 5", product.getNombre());
        assertEquals(499.99, product.getPrecio());
    }
}