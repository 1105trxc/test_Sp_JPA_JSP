package com.testd1.service.impl;

import org.springframework.stereotype.Service;

import com.testd1.entity.User;
import com.testd1.repository.UserRepository;
import com.testd1.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User register(User user) {
        // Đơn giản: lưu plain password theo đề (bài thi). Thực tế nên mã hoá.
        if (user.getActive() == null) user.setActive(true);
        if (user.getAdmin() == null) user.setAdmin(false);
        return repo.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findById(username);
    }

    @Override
    public Optional<User> login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}