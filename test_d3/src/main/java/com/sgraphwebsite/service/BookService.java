package com.sgraphwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgraphwebsite.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // Business Logic
}