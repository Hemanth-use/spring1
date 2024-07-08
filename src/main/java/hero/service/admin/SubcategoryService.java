package hero.service.admin;

import hero.entity.admin.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    List<Subcategory> getSubcategoriesByCategoryId(Long categoryId);


        Optional<Subcategory> findById(Long id);


//    Subcategory createSubcategory(Subcategory subcategory);

    List<Subcategory> getAllSubcategories();

    Subcategory getSubcategoryById(Long id);

    Subcategory createSubcategory(Subcategory subcategory);

    Subcategory updateSubcategory(Long id, Subcategory subcategory);

    void deleteSubcategory(Long id);
}
