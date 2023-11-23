package com.example.jwt.infra;

import com.example.jwt.domain.User;
import com.example.jwt.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private HashMap<String, User> _users;

    UserRepositoryImpl() {
        _users = new HashMap<>();
    }

    @Override
    public void save(User user) {
        _users.put(user.getEmail(), user);
    }

    @Override
    public User getByEmail(String email) {
        return _users.get(email);
    }
}
