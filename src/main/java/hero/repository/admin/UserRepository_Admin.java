// UserRepository_Admin.java
package hero.repository.admin;

import hero.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository_Admin extends JpaRepository<User, Long> {

}
