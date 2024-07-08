package hero.service.sign_login_service;

import hero.entity.User;
import hero.repository.UserRepository;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signupUser(SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()) != null) {
            throw new RuntimeException("Username already exists!");
        }

        if (userRepository.findByEmail(signupRequest.getEmail()) != null) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setFullName(signupRequest.getFullName());
        user.setAddress(signupRequest.getAddress());
        user.setPhoneNumber(signupRequest.getPhoneNumber());

        return userRepository.save(user);
    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUsernameOrEmail());

        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password!");
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }



}