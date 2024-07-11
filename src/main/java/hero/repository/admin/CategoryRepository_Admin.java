package hero.repository.admin;

import hero.entity.admin.Category_Admin;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository_Admin extends JpaRepository<Category_Admin, Long> {


    List<Category_Admin> findByParentCategoryId(Long parentId);

}

