package hero.controller;

import hero.entity.User;
import hero.service.sign_login_service.UserService;
import hero.sign_loginDto.LoginRequest;
import hero.sign_loginDto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        User user = userService.signupUser(signupRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest);
        return ResponseEntity.ok(user);
    }


//    @GetMapping
//    public List<User> findByPhoneNumber(@RequestParam String phoneNumber) {
//        return (List<User>) userService.findByPhoneNumber(phoneNumber);
//    }

}
