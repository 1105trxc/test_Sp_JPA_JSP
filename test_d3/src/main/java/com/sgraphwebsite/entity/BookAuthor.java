package com.sgraphwebsite.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_author")
@IdClass(BookAuthorId.class)
public class BookAuthor implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}