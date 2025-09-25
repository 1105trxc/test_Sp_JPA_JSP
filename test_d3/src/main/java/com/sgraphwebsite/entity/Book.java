package com.sgraphwebsite.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private int bookid;
    private int isbn;
    private String title;
    private String publisher;
    private BigDecimal price;
    private String description;
    private LocalDate publish_date;
    private String cover_image;
    private int quantity;
    // Getters, Setters, Relationships
}