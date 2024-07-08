package hero.service.admin;

import hero.entity.admin.Category_Admin;

import java.util.List;

public interface CategoryService_Admin {
    List<Category_Admin> getAllCategories();
    Category_Admin getCategoryById(Long id);
    Category_Admin findById(Long id);
    Category_Admin createCategory(Category_Admin category);
    Category_Admin updateCategory(Long id, Category_Admin category);
    void deleteCategory(Long id);
    List<Category_Admin> getSubCategories(Long parentId);
}
