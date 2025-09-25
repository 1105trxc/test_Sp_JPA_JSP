package com.sgraphwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgraphwebsite.repository.BookRepository;

@Service
public class BookAuthorService {
    @Autowired
    private BookAuthorService bookAuthorRepository;
    // Business Logic
}