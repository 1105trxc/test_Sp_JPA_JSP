package com.sgraphwebsite.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<Rating> ratings;

    // Getters, Setters, Relationships
    public int getBookid() { return bookid; }
    public void setBookid(int bookid) { this.bookid = bookid; }
    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getPublish_date() { return publish_date; }
    public void setPublish_date(LocalDate publish_date) { this.publish_date = publish_date; }
    public String getCover_image() { return cover_image; }
    public void setCover_image(String cover_image) { this.cover_image = cover_image; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }
    public List<Rating> getRatings() { return ratings; }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }

    @Transient
    public Double getAverageRating() {
        if (ratings == null || ratings.isEmpty()) return null;
        double sum = 0;
        for (Rating r : ratings) {
            if (r.getRating() != null) sum += r.getRating();
        }
        return sum / ratings.size();
    }
}