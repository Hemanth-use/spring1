package hero.service.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.ProductImage_Admin;
import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;
import hero.repository.admin.CategoryRepository_Admin;
import hero.repository.admin.ProductImageRepository_Admin;
import hero.repository.admin.ProductRepository_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService_AdminImpl implements ProductService_Admin {

    @Autowired
    private ProductRepository_Admin productsRepositoryAdmin;
    @Autowired
    private SubcategoryService subcategoryService;
    @Autowired
    private CategoryRepository_Admin categoryRepositoryAdmin;
    @Autowired
    private ProductImageRepository_Admin productImageRepositoryAdmin;

    @Override
    public List<Products_Admin> getAllProducts() {
        return productsRepositoryAdmin.findAll();
    }

    @Override
    public Products_Admin getProductById(Long id) {
        return productsRepositoryAdmin.findById(id).orElse(null);
    }

    @Override
    public List<Products_Admin> getProductsByCategoryId(Long categoryId) {
        Optional<Category_Admin> categoryOptional = categoryRepositoryAdmin.findById(categoryId);
        Category_Admin categoryAdmin = categoryOptional.orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + categoryId));
        return productsRepositoryAdmin.findByCategory(categoryAdmin);
    }

    @Override
    public List<Products_Admin> findBySubcategoryId(Long subcategoryId) {
        Subcategory subcategory = subcategoryService.findById(subcategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Subcategory not found with ID: " + subcategoryId));
        return productsRepositoryAdmin.findBySubcategory(subcategory);
    }

    @Override
    public Products_Admin createProduct(Products_Admin product) {
        try {
            if (product.getSubcategory() == null || product.getSubcategory().getId() == null) {
                throw new IllegalArgumentException("Subcategory ID cannot be null");
            }

            Long subcategoryId = product.getSubcategory().getId();
            Subcategory subcategory = subcategoryService.findById(subcategoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Subcategory not found with ID: " + subcategoryId));

            product.setSubcategory(subcategory);

            Products_Admin savedProduct = productsRepositoryAdmin.save(product);

            if (product.getImages() != null && !product.getImages().isEmpty()) {
                for (ProductImage_Admin image : product.getImages()) {
                    image.setProduct(savedProduct);
                    productImageRepositoryAdmin.save(image);
                }
                savedProduct.setImages(product.getImages());
            }

            return savedProduct;
        } catch (Exception e) {
            throw new RuntimeException("Error creating product: " + e.getMessage());
        }
    }

    @Override
    public Products_Admin updateProduct(Long id, Products_Admin product) {
        if (!productsRepositoryAdmin.existsById(id)) {
            throw new IllegalArgumentException("Product not found with ID: " + id);
        }

        try {
            product.setId(id);
            return productsRepositoryAdmin.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error updating product: " + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productsRepositoryAdmin.deleteById(id);
        productImageRepositoryAdmin.deleteByProductId(id);
    }

    @Override
    public void saveProduct(Products_Admin product) {
        if (product.getId() == null) {
            createProduct(product);
        } else {
            updateProduct(product.getId(), product);
        }
    }

    @Override
    public Optional<Category_Admin> findById(Long id) {
        return categoryRepositoryAdmin.findById(id);
    }
}
