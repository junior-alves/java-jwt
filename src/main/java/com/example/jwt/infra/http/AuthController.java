package com.example.jwt.infra.http;

import com.example.jwt.domain.User;
import com.example.jwt.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map data) {
        var userpass = new UsernamePasswordAuthenticationToken(data.get("email"), data.get("pass"));
        var auth = authenticationManager.authenticate(userpass);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Map data) {
        var pass = new BCryptPasswordEncoder().encode(data.get("pass").toString());
        var user = User.builder()
                .email(data.get("email").toString())
                .pass(pass).build();
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
