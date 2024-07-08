// UserService_AdminImpl.java
package hero.service.admin;

import hero.entity.User;
import hero.repository.admin.UserRepository_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService_AdminImpl implements UserService_Admin {

    @Autowired
    private UserRepository_Admin userRepositoryAdmin;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryAdmin.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepositoryAdmin.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryAdmin.deleteById(id);
    }
}
