package com.example.jwt.domain;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthorizationService implements UserDetailsService {

    private static String SECRET = "8f936f52-89f1-11ee-b9d1-0242ac120002";
    private static String ISSUER = "JWT";

    private static Algorithm ALG = Algorithm.HMAC256(SECRET);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByEmail(username);
    }

    public String generateToken(User user){
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(user.getEmail())
                .withExpiresAt(getExpiration())
                .sign(ALG);
    }

    public UserDetails validateToken(String token) {
        var email = JWT.require(ALG).withIssuer(ISSUER).build().verify(token).getSubject();
        return loadUserByUsername(email);
    }

    private Instant getExpiration() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
