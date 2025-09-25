package com.sgraphwebsite.service;

import org.springframework.stereotype.Service;

import com.sgraphwebsite.repository.BookAuthorRepository;

@Service
public class BookAuthorService {
    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }
    // Add business logic methods as needed
}