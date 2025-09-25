package com.sgraphwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgraphwebsite.entity.BookAuthor;
import com.sgraphwebsite.entity.BookAuthorId;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {}