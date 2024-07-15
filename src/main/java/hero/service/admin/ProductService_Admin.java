package hero.service.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.Products_Admin;

import java.util.List;
import java.util.Optional;

public interface ProductService_Admin {
    List<Products_Admin> getAllProducts();
    Products_Admin getProductById(Long id);
    List<Products_Admin> findBySubcategoryId(Long subcategoryId);
    Products_Admin createProduct(Products_Admin product);
    Products_Admin updateProduct(Long id, Products_Admin product);
    Optional<Category_Admin> findById(Long id);
    List<Products_Admin> getProductsByCategoryId(Long categoryId);
    void deleteProduct(Long id);
    void saveProduct(Products_Admin product);
}
