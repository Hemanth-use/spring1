package hero.service.admin;

import hero.entity.admin.ProductImage_Admin;
import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;
import hero.repository.admin.CategoryRepository_Admin;
import hero.repository.admin.ProductRepository_Admin;
import hero.repository.admin.ProductImageRepository_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService_AdminImpl implements ProductService_Admin {

    @Autowired
    private ProductRepository_Admin productsRepositoryAdmin;
    @Autowired
    private SubcategoryService subcategoryService;

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
    public List<Products_Admin> findBySubcategoryId(Long subcategoryId) {
        Subcategory subcategory = subcategoryService.findById(subcategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Subcategory not found with ID: " + subcategoryId));
        return productsRepositoryAdmin.findBySubcategory(subcategory);
    }

    @Override
    public Products_Admin createProduct(Products_Admin product) {
        try {
            // Check if the product has a subcategory
            if (product.getSubcategory() == null || product.getSubcategory().getId() == null) {
                throw new IllegalArgumentException("Subcategory ID cannot be null");
            }

            // Retrieve the subcategory from the database using its ID
            Long subcategoryId = product.getSubcategory().getId();
            Subcategory subcategory = subcategoryService.findById(subcategoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Subcategory not found with ID: " + subcategoryId));

            // Set the retrieved subcategory in the product
            product.setSubcategory(subcategory);

            // Save the product
            Products_Admin savedProduct = productsRepositoryAdmin.save(product);

            // Save product images (if any)
            if (product.getImages() != null && !product.getImages().isEmpty()) {
                for (ProductImage_Admin image : product.getImages()) {
                    // Set the product for each image
                    image.setProduct(savedProduct);

                    // Save the image
                    productImageRepositoryAdmin.save(image);
                }
                // Associate the saved images with the saved product
                savedProduct.setImages(product.getImages());
            }

            return savedProduct;
        } catch (Exception e) {
            throw new RuntimeException("Error creating product: " + e.getMessage());
        }
    }

    @Override
    public Products_Admin updateProduct(Long id, Products_Admin product) {
        // Check if the product exists
        if (!productsRepositoryAdmin.existsById(id)) {
            throw new IllegalArgumentException("Product not found with ID: " + id);
        }

        try {
            // Set the ID of the product
            product.setId(id);

            // Save the product
            return productsRepositoryAdmin.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error updating product: " + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        // Delete product by ID
        productsRepositoryAdmin.deleteById(id);

        // Delete associated product images
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
}
