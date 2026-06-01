package com.gamingstore.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingstore.backend.entity.Product;
import com.gamingstore.backend.repository.ProductRepository;

/*
 * Service de productos
 * 
 * Aquí va la lógica de negocio.
 * El controller usará este service.
 */

@Service
public class ProductService {

    // Inyección automática del repository
    @Autowired
    private ProductRepository productRepository;

    /*
     * Obtener todos los productos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /*
     * Obtener producto por ID
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /*
     * Crear producto
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /*
     * Actualizar producto
     */
    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {

            product.setNombre(updatedProduct.getNombre());
            product.setDescripcion(updatedProduct.getDescripcion());
            product.setPrecio(updatedProduct.getPrecio());
            product.setStock(updatedProduct.getStock());
            product.setCategoria(updatedProduct.getCategoria());

            return productRepository.save(product);
        }

        return null;
    }

    /*
     * Eliminar producto
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /*
     * Buscar productos por nombre
     */
    public List<Product> searchByNombre(String nombre) {
        return productRepository.findByNombreContainingIgnoreCase(nombre);
    }

    /*
     * Filtrar por categoría
     */
    public List<Product> filterByCategoria(String categoria) {
        return productRepository.findByCategoriaIgnoreCase(categoria);
    }

    /*
     * Filtrar por precio
     */
    public List<Product> filterByPrecio(Double minPrice, Double maxPrice) {
        return productRepository.findByPrecioBetween(minPrice, maxPrice);
    }

    /*
     * Filtrar productos con stock
     */
    public List<Product> filterByStock() {
        return productRepository.findByStockGreaterThan(0);
    }
}