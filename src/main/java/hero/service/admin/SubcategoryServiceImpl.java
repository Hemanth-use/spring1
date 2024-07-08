package hero.service.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.Subcategory;
import hero.repository.admin.SubcategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService_Admin categoryService;

    @Override
    public List<Subcategory> getSubcategoriesByCategoryId(Long categoryId) {
        return subcategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return subcategoryRepository.findById(id);
    }

    @Transactional
    public void createOrUpdateSubcategory(Subcategory subcategory) {
        Category_Admin category = categoryService.findById(subcategory.getCategory().getId());
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);
    }



    @Override
    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory updateSubcategory(Long id, Subcategory updatedSubcategory) {
        Subcategory subcategory = subcategoryRepository.findById(id).orElse(null);
        if (subcategory != null) {
            subcategory.setName(updatedSubcategory.getName());
            return subcategoryRepository.save(subcategory);
        }
        return null;
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}

