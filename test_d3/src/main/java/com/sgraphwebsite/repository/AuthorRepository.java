package com.sgraphwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgraphwebsite.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {}