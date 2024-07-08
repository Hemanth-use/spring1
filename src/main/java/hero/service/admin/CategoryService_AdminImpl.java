package hero.service.admin;

import hero.entity.admin.Category_Admin;
import hero.repository.admin.CategoryRepository_Admin;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService_AdminImpl implements CategoryService_Admin {

    @Autowired
    private CategoryRepository_Admin categoryRepositoryAdmin;

    @Transactional
    @Override
    public Category_Admin createCategory(Category_Admin category) {
        return categoryRepositoryAdmin.save(category);
    }

    @Override
    public List<Category_Admin> getAllCategories() {
        return categoryRepositoryAdmin.findAll();
    }

//    @Override
//    public Category_Admin getCategoryById(Long id) {
//
//        return categoryRepositoryAdmin.findById(id).orElse(null);
//    }
    @Override
    public Category_Admin getCategoryById(Long id) {
        Category_Admin categoryAdmin = categoryRepositoryAdmin.findById(id).orElse(null);
        if (categoryAdmin != null) {
            Hibernate.initialize(categoryAdmin.getSubCategories());
        }
        return categoryAdmin;
    }


    @Override
    public Category_Admin findById(Long id) {
        return null;
    }

    @Override
    public List<Category_Admin> getSubCategories(Long parentId) {
        return categoryRepositoryAdmin.findByParentCategoryId(parentId);
    }

    @Transactional
    @Override
    public Category_Admin updateCategory(Long id, Category_Admin category) {
        if (categoryRepositoryAdmin.existsById(id)) {
            category.setId(id);
            return categoryRepositoryAdmin.save(category);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteCategory(Long id) {
        categoryRepositoryAdmin.deleteById(id);
    }
}
