package com.sgraphwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgraphwebsite.repository.BookRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorService authorRepository;
    // Business Logic
}