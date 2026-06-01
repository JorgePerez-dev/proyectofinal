package com.gamingstore.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamingstore.backend.entity.Product;
import com.gamingstore.backend.service.ProductService;

/*
 * Controller de productos
 * 
 * Aquí llegan las peticiones HTTP del frontend.
 * 
 * Ejemplo:
 * fetch("http://localhost:8080/api/products")
 */

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    // Conectamos el service automáticamente
    @Autowired
    private ProductService productService;

    /*
     * GET
     * Obtener todos los productos
     * 
     * GET /api/products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /*
     * GET
     * Obtener producto por ID
     * 
     * GET /api/products/1
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /*
     * POST
     * Crear producto
     * 
     * POST /api/products
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /*
     * PUT
     * Actualizar producto
     * 
     * PUT /api/products/1
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product updatedProduct) {

        return productService.updateProduct(id, updatedProduct);
    }

    /*
     * DELETE
     * Eliminar producto
     * 
     * DELETE /api/products/1
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    /*
     * Buscar productos por nombre
     * 
     * GET /api/products/search?nombre=monitor
     */
    @GetMapping("/search")
    public List<Product> searchByNombre(@RequestParam String nombre) {
        return productService.searchByNombre(nombre);
    }

    /*
     * Filtrar por categoría
     * 
     * GET /api/products/category/gaming
     */
    @GetMapping("/category/{categoria}")
    public List<Product> filterByCategoria(@PathVariable String categoria) {
        return productService.filterByCategoria(categoria);
    }

    /*
     * Filtrar por precio
     * 
     * GET /api/products/precio?min=100&max=500
     */
    @GetMapping("/precio")
    public List<Product> filterByPrecio(@RequestParam Double min,
                                        @RequestParam Double max) {

        return productService.filterByPrecio(min, max);
    }

    /*
     * Filtrar productos con stock
     * 
     * GET /api/products/stock
     */
    @GetMapping("/stock")
    public List<Product> filterByStock() {
        return productService.filterByStock();
    }
}