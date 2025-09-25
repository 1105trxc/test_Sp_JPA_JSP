package com.sgraphwebsite.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Id
    private int author_id;
    private String author_name;
    private LocalDate date_of_birth;
    // Getters, Setters
}