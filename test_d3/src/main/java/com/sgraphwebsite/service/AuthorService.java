package com.sgraphwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgraphwebsite.entity.Author;
import com.sgraphwebsite.repository.AuthorRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() { return authorRepository.findAll(); }
    public Optional<Author> findById(Integer id) { return authorRepository.findById(id); }
    public Author save(Author a) { return authorRepository.save(a); }
    public void deleteById(Integer id) { authorRepository.deleteById(id); }
}