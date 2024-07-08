package hero.service.sign_login_service;

import hero.entity.User;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;

public interface UserService {
    User signupUser(SignupRequest signupRequest);
    User loginUser(LoginRequest loginRequest);

    User findByUsername(String username);

//    User findByPhoneNumber(String phoneNumber);


}

