package hero.controller.admin;
import hero.entity.admin.Subcategory;
import hero.service.admin.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Subcategory>> getSubcategoriesByCategoryId(@PathVariable Long categoryId) {
        List<Subcategory> subcategories = subcategoryService.getSubcategoriesByCategoryId(categoryId);
        return ResponseEntity.ok().body(subcategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable Long id) {
        Subcategory subcategory = subcategoryService.getSubcategoryById(id);
        return ResponseEntity.ok().body(subcategory);
    }

    @GetMapping
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<Subcategory> createSubcategory(@PathVariable Long categoryId, @RequestBody Subcategory subcategory) {
        subcategory.setCategoryId(categoryId);
        Subcategory createdSubcategory = subcategoryService.createSubcategory(subcategory);
        return ResponseEntity.ok(createdSubcategory);
    }

    @PutMapping("/{id}")
    public Subcategory updateSubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {
        return subcategoryService.updateSubcategory(id, subcategory);
    }

    @DeleteMapping("/{id}")
    public void deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
