package com.sgraphwebsite.service;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgraphwebsite.entity.User;
import com.sgraphwebsite.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User u) {
        u.setSignup_date(LocalDateTime.now());
        u.setLast_login(LocalDateTime.now());
        if (u.getIs_admin() == null) u.setIs_admin(false);
        u.setPasswd(md5(u.getPasswd()));
        return userRepository.save(u);
    }

    public User login(String email, String password) {
        String emailTrim = email == null ? null : email.trim();
        String passwordTrim = password == null ? null : password.trim();
        Optional<User> opt = userRepository.findByEmail(emailTrim);
        if (opt.isPresent()) {
            User u = opt.get();
            String inputHash = md5(passwordTrim);
            String dbHash = u.getPasswd();
            System.out.println("[DEBUG] Login attempt: email=" + emailTrim + ", inputHash=" + inputHash + ", dbHash=" + dbHash);
            if (dbHash != null && dbHash.equals(inputHash)) {
                u.setLast_login(LocalDateTime.now());
                userRepository.save(u);
                return u;
            } else {
                System.out.println("[DEBUG] Password mismatch");
            }
        } else {
            System.out.println("[DEBUG] Email not found: " + emailTrim);
        }
        return null;
    }

    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] r = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : r) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return input;
        }
    }
}