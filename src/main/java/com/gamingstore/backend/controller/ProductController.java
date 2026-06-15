
package com.gamingstore.backend.controller;

// Importamos List para devolver listas de productos.
import java.util.List;

// Permite inyectar automáticamente dependencias de Spring.
import org.springframework.beans.factory.annotation.Autowired;

// Importamos las anotaciones REST de Spring.
import org.springframework.web.bind.annotation.*;

// Importamos la entidad Product.
import com.gamingstore.backend.entity.Product;

// Importamos el servicio de productos.
import com.gamingstore.backend.service.ProductService;

// Controlador REST encargado de gestionar productos.
@RestController

// Ruta base para todos los endpoints de productos.
@RequestMapping("/api/products")

// Permite peticiones desde el frontend.
@CrossOrigin("*")
public class ProductController {

    // Inyectamos automáticamente el servicio de productos.
    @Autowired
    private ProductService productService;

    /*
     * =====================================
     * OBTENER TODOS LOS PRODUCTOS
     * =====================================
     */

    // Endpoint para obtener todos los productos.
    @GetMapping
    public List<Product> getAllProducts() {

        // Devuelve todos los productos desde el servicio.
        return productService.getAllProducts();
    }

    /*
     * =====================================
     * OBTENER PRODUCTO POR ID
     * =====================================
     */

    // Endpoint para obtener un producto por su ID.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        // Busca y devuelve un producto usando su ID.
        return productService.getProductById(id);
    }

    /*
     * =====================================
     * CREAR PRODUCTO
     * =====================================
     */

    // Endpoint para crear un nuevo producto.
    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        // Guarda el producto recibido desde el frontend.
        return productService.createProduct(product);
    }

    /*
     * =====================================
     * ACTUALIZAR PRODUCTO
     * =====================================
     */

    // Endpoint para actualizar un producto existente.
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {

        // Actualiza el producto con el ID indicado.
        return productService.updateProduct(
                id,
                updatedProduct);
    }

    /*
     * =====================================
     * ELIMINAR PRODUCTO
     * =====================================
     */

    // Endpoint para eliminar un producto por ID.
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

        // Elimina el producto usando el servicio.
        productService.deleteProduct(id);
    }

    /*
     * =====================================
     * BUSCAR PRODUCTOS POR NOMBRE
     * =====================================
     */

    // Endpoint para buscar productos por nombre.
    @GetMapping("/search")
    public List<Product> searchByNombre(
            @RequestParam String nombre) {

        // Devuelve productos cuyo nombre contiene el texto indicado.
        return productService.searchByNombre(nombre);
    }

    /*
     * =====================================
     * FILTRAR POR CATEGORÍA
     * =====================================
     */

    // Endpoint para filtrar productos por categoría.
    @GetMapping("/category/{categoria}")
    public List<Product> filterByCategoria(
            @PathVariable String categoria) {

        // Devuelve productos de la categoría indicada.
        return productService.filterByCategoria(categoria);
    }

    /*
     * =====================================
     * FILTRAR POR PRECIO
     * =====================================
     */

    // Endpoint para filtrar productos por rango de precio.
    @GetMapping("/precio")
    public List<Product> filterByPrecio(
            @RequestParam Double min,
            @RequestParam Double max) {

        // Devuelve productos cuyo precio está entre mínimo y máximo.
        return productService.filterByPrecio(min, max);
    }

    /*
     * =====================================
     * FILTRAR POR STOCK
     * =====================================
     */

    // Endpoint para obtener productos con stock disponible.
    @GetMapping("/stock")
    public List<Product> filterByStock() {

        // Devuelve productos cuyo stock es mayor que cero.
        return productService.filterByStock();
    }
}
