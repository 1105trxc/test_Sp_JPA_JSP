package com.sgraphwebsite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.sgraphwebsite.entity.*;

@Entity
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    // Getters, Setters
}
