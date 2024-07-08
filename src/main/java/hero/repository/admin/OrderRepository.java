package hero.repository.admin;
import hero.entity.admin.Orders_Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders_Admin, Long> {

}

