package hero.service.sign_login_service;

import hero.entity.Admin;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;

import java.util.List;

public interface AdminService {
    Admin signupAdmin(SignupRequest signupRequest);
    Admin loginAdmin(LoginRequest loginRequest);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin updateAdmin(Long id, SignupRequest signupRequest);
    void deleteAdmin(Long id);
}
