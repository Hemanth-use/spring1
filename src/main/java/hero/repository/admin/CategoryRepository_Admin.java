package hero.repository.admin;

import hero.entity.admin.Category_Admin;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository_Admin extends JpaRepository<Category_Admin, Long> {
    Category_Admin findByName(String name);
    Category_Admin findById(Category_Admin categoryId);
    List<Category_Admin> findByParentCategory_Id(Long parentId);

    List<Category_Admin> findByParentCategoryId(Long parentId);

}

