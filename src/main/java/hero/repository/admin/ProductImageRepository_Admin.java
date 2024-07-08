package hero.repository.admin;

import hero.entity.admin.ProductImage_Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository_Admin extends JpaRepository<ProductImage_Admin, Long> {

   void deleteByProductId(Long id);
}
