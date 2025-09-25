package com.sgraphwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgraphwebsite.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {}