package com.testd1.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.testd1.entity.User;
import com.testd1.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpServletRequest request,
                          Model model) {
        return userService.login(username, password)
                .map(u -> {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentUser", u);
                    session.setAttribute("isAdmin", Boolean.TRUE.equals(u.getAdmin()));
                    return "redirect:/";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
                    return "auth/login";
                });
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("user") @Valid User form,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "auth/register";
        }
        if (userService.findByUsername(form.getUsername()).isPresent()) {
            model.addAttribute("error", "Username đã tồn tại");
            return "auth/register";
        }
        userService.register(form);
        model.addAttribute("msg", "Đăng ký thành công. Mời đăng nhập!");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "redirect:/login?logout";
    }
}
