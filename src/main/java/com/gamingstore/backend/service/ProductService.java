package com.gamingstore.backend.service;

// Importamos List para devolver listas de productos.
import java.util.List;

// Permite inyectar automáticamente dependencias de Spring.
import org.springframework.beans.factory.annotation.Autowired;

// Indica que esta clase es un servicio de Spring.
import org.springframework.stereotype.Service;

// Importamos la entidad Product.
import com.gamingstore.backend.entity.Product;

// Importamos el repositorio de productos.
import com.gamingstore.backend.repository.ProductRepository;

// Servicio encargado de la lógica de productos.
@Service
public class ProductService {


// Inyectamos automáticamente el repositorio de productos.
@Autowired
private ProductRepository productRepository;

/*
 * =====================================
 * OBTENER TODOS LOS PRODUCTOS
 * =====================================
 */

// Devuelve todos los productos guardados en la base de datos.
public List<Product> getAllProducts() {

    // findAll obtiene todos los registros de la tabla products.
    return productRepository.findAll();
}

/*
 * =====================================
 * OBTENER PRODUCTO POR ID
 * =====================================
 */

// Busca un producto usando su ID.
public Product getProductById(Long id) {

    // Si encuentra el producto lo devuelve, si no devuelve null.
    return productRepository.findById(id).orElse(null);
}

/*
 * =====================================
 * CREAR PRODUCTO
 * =====================================
 */

// Guarda un nuevo producto en la base de datos.
public Product createProduct(Product product) {

    // save inserta el producto en la tabla products.
    return productRepository.save(product);
}

/*
 * =====================================
 * ACTUALIZAR PRODUCTO
 * =====================================
 */

// Actualiza un producto existente usando su ID.
public Product updateProduct(Long id, Product updatedProduct) {

    // Busca el producto que se quiere actualizar.
    Product product =
            productRepository.findById(id).orElse(null);

    // Si el producto existe, se actualizan sus datos.
    if (product != null) {

        // Actualiza el nombre del producto.
        product.setNombre(updatedProduct.getNombre());

        // Actualiza la descripción del producto.
        product.setDescripcion(updatedProduct.getDescripcion());

        // Actualiza el precio del producto.
        product.setPrecio(updatedProduct.getPrecio());

        // Actualiza el stock del producto.
        product.setStock(updatedProduct.getStock());

        // Actualiza la categoría del producto.
        product.setCategoria(updatedProduct.getCategoria());

        // Guarda los cambios en la base de datos.
        return productRepository.save(product);
    }

    // Si el producto no existe, devuelve null.
    return null;
}

/*
 * =====================================
 * ELIMINAR PRODUCTO
 * =====================================
 */

// Elimina un producto usando su ID.
public void deleteProduct(Long id) {

    // deleteById elimina el producto de la base de datos.
    productRepository.deleteById(id);
}

/*
 * =====================================
 * BUSCAR POR NOMBRE
 * =====================================
 */

// Busca productos cuyo nombre contenga el texto indicado.
public List<Product> searchByNombre(String nombre) {

    // Consulta generada automáticamente por Spring Data JPA.
    return productRepository.findByNombreContainingIgnoreCase(nombre);
}

/*
 * =====================================
 * FILTRAR POR CATEGORÍA
 * =====================================
 */

// Filtra productos por categoría.
public List<Product> filterByCategoria(String categoria) {

    // Busca productos coincidiendo con la categoría sin importar mayúsculas.
    return productRepository.findByCategoriaIgnoreCase(categoria);
}

/*
 * =====================================
 * FILTRAR POR PRECIO
 * =====================================
 */

// Filtra productos entre un precio mínimo y máximo.
public List<Product> filterByPrecio(Double minPrice, Double maxPrice) {

    // Busca productos cuyo precio esté dentro del rango.
    return productRepository.findByPrecioBetween(minPrice, maxPrice);
}

/*
 * =====================================
 * FILTRAR POR STOCK
 * =====================================
 */

// Devuelve productos que tengan stock disponible.
public List<Product> filterByStock() {

    // Busca productos cuyo stock sea mayor que 0.
    return productRepository.findByStockGreaterThan(0);
}

}
