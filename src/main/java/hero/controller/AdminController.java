package hero.controller;

import hero.entity.Admin;
import hero.service.sign_login_service.AdminService;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupAdmin(@RequestBody SignupRequest signupRequest) {
        Admin admin = adminService.signupAdmin(signupRequest);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginRequest loginRequest) {
        try {
            Admin admin = adminService.loginAdmin(loginRequest);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/admins/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/admins/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Long id, @RequestBody SignupRequest signupRequest) {
        Admin admin = adminService.updateAdmin(id, signupRequest);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("/admins/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }
}
