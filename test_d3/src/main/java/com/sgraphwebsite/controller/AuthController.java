package com.sgraphwebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sgraphwebsite.entity.User;
import com.sgraphwebsite.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        User u = userService.login(email, password);
        if (u != null) {
            session.setAttribute("currentUser", u);
            if (Boolean.TRUE.equals(u.getIs_admin())) {
                return "redirect:/admin";
            }
            return "redirect:/";
        }
        model.addAttribute("error", "Đăng nhập thất bại!");
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute User user, Model model) {
        userService.register(user);
        model.addAttribute("msg", "Đăng ký thành công, hãy đăng nhập.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
