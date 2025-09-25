package com.sgraphwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgraphwebsite.entity.Book;

public interface BookAuthorRepository extends JpaRepository<Book, Integer> {}