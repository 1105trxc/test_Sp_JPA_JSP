package com.sgraphwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sgraphwebsite.service.BookService;

import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/products")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "products";
    }
}