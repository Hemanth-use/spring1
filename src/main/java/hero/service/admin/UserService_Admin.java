// UserService_Admin.java
package hero.service.admin;
import hero.entity.User;

import java.util.List;

public interface UserService_Admin {

        List<User> getAllUsers();
    User getUserById(Long id);
        void deleteUser(Long id);
}
