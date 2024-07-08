package hero.service.admin;

import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;

import java.util.List;

public interface ProductService_Admin {

//    List<Products_Admin> getProductsBySubcategoryId(Long subcategoryId);

    List<Products_Admin> getAllProducts();
    Products_Admin getProductById(Long id);

//    List<Products_Admin> getProductsByCategoryId(Long categoryId);
    List<Products_Admin> findBySubcategoryId(Long subcategoryId);

    Products_Admin createProduct(Products_Admin product);
    Products_Admin updateProduct(Long id, Products_Admin product);

    void deleteProduct(Long id);
    void saveProduct(Products_Admin product);

//    List<Products_Admin> getProductsByCategoryName(String categoryName);


}

