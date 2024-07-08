package hero.controller.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.Products_Admin;
import hero.service.admin.CategoryService_Admin;
import hero.service.admin.ProductService_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryController_Admin {

    @Autowired
    private CategoryService_Admin categoryService;

    @Autowired
    private ProductService_Admin productService;

    @GetMapping
    public List<Category_Admin> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category_Admin> getCategoryById(@PathVariable Long id) {
        Category_Admin category = categoryService.getCategoryById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category_Admin> createCategory(@RequestBody Category_Admin category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category_Admin> updateCategory(@PathVariable Long id, @RequestBody Category_Admin category) {
        Category_Admin updatedCategory = categoryService.updateCategory(id, category);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
//    @GetMapping("/{categoryId}/products")
//    public ResponseEntity<List<Products_Admin>> getProductsByCategoryId(@PathVariable Long categoryId) {
//        List<Products_Admin> products = productService.getProductsByCategoryId(categoryId);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/{categories}/subcategories")
    public ResponseEntity<List<Category_Admin>> getSubCategories(@PathVariable Long parentId) {
        List<Category_Admin> subCategories = categoryService.getSubCategories(parentId);
        return ResponseEntity.ok(subCategories);
    }
}

