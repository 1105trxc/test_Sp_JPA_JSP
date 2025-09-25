package com.sgraphwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Entity;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Entity model) { return "home"; }
}