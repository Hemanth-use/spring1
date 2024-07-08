package hero.service.sign_login_service;

import hero.entity.Admin;
import hero.repository.AdminRepository;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin signupAdmin(SignupRequest signupRequest) {
        if (adminRepository.findByUsername(signupRequest.getUsername()) != null) {
            throw new RuntimeException("Username already exists!");
        }

        if (adminRepository.findByEmail(signupRequest.getEmail()) != null) {
            throw new RuntimeException("Email already exists!");
        }

        Admin admin = new Admin();
        admin.setUsername(signupRequest.getUsername());
        admin.setEmail(signupRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        admin.setFullName(signupRequest.getFullName());
        admin.setRole(signupRequest.getRole()); // Assuming the role is set in the signup request

        return adminRepository.save(admin);
    }

    @Override
    public Admin loginAdmin(LoginRequest loginRequest) {
        String usernameOrEmail = loginRequest.getUsernameOrEmail();
        String password = loginRequest.getPassword();

        if (usernameOrEmail == null || usernameOrEmail.isEmpty() || password == null || password.isEmpty()) {
            throw new RuntimeException("Username/email or password is null or empty!");
        }

        Admin admin = adminRepository.findByEmail(usernameOrEmail);
        if (admin == null) {
            admin = adminRepository.findByUsername(usernameOrEmail);
        }

        if (admin == null || !passwordEncoder.matches(password, admin.getPassword())) {
            throw new RuntimeException("Invalid username/email or password!");
        }

        return admin;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin updateAdmin(Long id, SignupRequest signupRequest) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setUsername(signupRequest.getUsername());
            admin.setEmail(signupRequest.getEmail());
            admin.setFullName(signupRequest.getFullName());
            admin.setRole(signupRequest.getRole()); // Assuming the role is set in the signup request
            // Update any other fields as needed
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
