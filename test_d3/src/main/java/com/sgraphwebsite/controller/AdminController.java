package com.sgraphwebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sgraphwebsite.entity.User;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin(HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u == null || !Boolean.TRUE.equals(u.getIs_admin())) {
            return "redirect:/login";
        }
        return "admin";
    }
}