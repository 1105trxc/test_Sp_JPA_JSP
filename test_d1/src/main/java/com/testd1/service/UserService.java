package com.testd1.service;

import java.util.Optional;

import com.testd1.entity.User;

public interface UserService {
    User register(User user);
    Optional<User> findByUsername(String username);
    Optional<User> login(String username, String password);
}
