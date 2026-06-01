package com.gamingstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamingstore.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Buscar productos por nombre
    List<Product> findByNombreContainingIgnoreCase(String nombre);

    // Buscar productos por categoría
    List<Product> findByCategoriaIgnoreCase(String categoria);

    // Buscar productos entre un precio mínimo y máximo
    List<Product> findByPrecioBetween(Double minPrice, Double maxPrice);

    // Buscar productos con stock mayor a 0
    List<Product> findByStockGreaterThan(Integer stock);
}