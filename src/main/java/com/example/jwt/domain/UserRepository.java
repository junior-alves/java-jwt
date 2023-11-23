package com.example.jwt.domain;

public interface UserRepository {
    public void save(User user);
    public User getByEmail(String email);
}
