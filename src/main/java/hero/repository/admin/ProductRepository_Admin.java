package hero.repository.admin;

import hero.entity.admin.Category_Admin;
import hero.entity.admin.Products_Admin;
import hero.entity.admin.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository_Admin extends JpaRepository<Products_Admin, Long> {
    List<Products_Admin> findBySubcategoryId(Long subcategoryId);
    List<Products_Admin> findBySubcategory(Subcategory subcategory);
    List<Products_Admin> findByCategory(Category_Admin categoryAdmin);
}
