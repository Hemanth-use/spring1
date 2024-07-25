package hero.controller.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;
import hero.service.admin.CategoryService_Admin;
import hero.service.admin.ProductService_Admin;
import hero.service.admin.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController_Admin {

    @Autowired
    private ProductService_Admin productService;

    @Autowired
    private CategoryService_Admin categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    public List<Products_Admin> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products_Admin> getProductById(@PathVariable Long id) {
        Products_Admin product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping("/category/{categoryId}/subcategory/{subcategoryId}")
    public ResponseEntity<Products_Admin> createProduct(
            @PathVariable Long categoryId,
            @PathVariable Long subcategoryId,
            @RequestBody Products_Admin product) {
        try {
            Optional<Category_Admin> categoryOptional = Optional.ofNullable(categoryService.findById(categoryId));
            if (categoryOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Category_Admin category = categoryOptional.get();

            Optional<Subcategory> subcategoryOptional = subcategoryService.findById(subcategoryId);
            if (subcategoryOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Subcategory subcategory = subcategoryOptional.get();

            product.setCategory(category);
            product.setSubcategory(subcategory);

            Products_Admin savedProduct = productService.createProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Products_Admin> updateProduct(@PathVariable Long id, @RequestBody Products_Admin product) {
        product.setImageUrl(product.getImageUrl());
        Products_Admin updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{subcategoryId}")
    public List<Products_Admin> getProductsBySubcategoryId(@PathVariable Long subcategoryId) {
        return productService.findBySubcategoryId(subcategoryId);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Products_Admin>> getProductsByCategoryId(@PathVariable Long categoryId) {
        try {
            List<Products_Admin> products = productService.getProductsByCategoryId(categoryId);
            return ResponseEntity.ok(products);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
