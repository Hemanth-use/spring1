package hero.controller.admin;

import hero.entity.User;
import hero.service.admin.UserService_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class UserController_Admin {

    @Autowired
    private UserService_Admin userService_admin;

    @GetMapping
    public List<User> getAllUsers() {
        return userService_admin.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService_admin.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService_admin.deleteUser(id);
        return ResponseEntity.ok("Record with ID " + id + " deleted successfully.");
    }
}
