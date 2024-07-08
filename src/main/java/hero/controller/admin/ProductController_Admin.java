package hero.controller.admin;

import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;
import hero.service.admin.ProductService_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController_Admin {

    @Autowired
    private ProductService_Admin productService;

    @GetMapping
    public List<Products_Admin> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products_Admin> getProductById(@PathVariable Long id) {
        Products_Admin product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

//    @PostMapping("/subcategory/{subcategoryId}")
//    public ResponseEntity<Products_Admin> createProduct(@RequestBody Products_Admin product) {
//        product.setImageUrl(product.getImageUrl());
//        return ResponseEntity.ok(productService.createProduct(product));
//    }
@PostMapping("/subcategory/{subcategoryId}")
public ResponseEntity<Products_Admin> createProduct(@PathVariable Long subcategoryId, @RequestBody Products_Admin product) {
    try {
        // Set the subcategory ID in the product
        Subcategory subcategory = new Subcategory();
        subcategory.setId(subcategoryId);
        product.setSubcategory(subcategory);

        // Save the product
        Products_Admin savedProduct = productService.createProduct(product);

        // Return the saved product
        return ResponseEntity.ok(savedProduct);
    } catch (Exception e) {
        // Handle any exceptions
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





}
