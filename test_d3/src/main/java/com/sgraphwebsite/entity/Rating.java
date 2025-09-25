package com.sgraphwebsite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
@IdClass(RatingId.class)
public class Rating {
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;

    private Byte rating;
    private String review_text;

    // Getters, Setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Byte getRating() { return rating; }
    public void setRating(Byte rating) { this.rating = rating; }
    public String getReview_text() { return review_text; }
    public void setReview_text(String review_text) { this.review_text = review_text; }
}