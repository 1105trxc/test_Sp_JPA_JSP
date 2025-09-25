package com.sgraphwebsite.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {
    private int user; // matches field name in Rating
    private int book; // matches field name in Rating

    public RatingId() {}
    public RatingId(int user, int book) { this.user = user; this.book = book; }
    public int getUser() { return user; }
    public void setUser(int user) { this.user = user; }
    public int getBook() { return book; }
    public void setBook(int book) { this.book = book; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId that = (RatingId) o;
        return user == that.user && book == that.book;
    }
    @Override
    public int hashCode() { return Objects.hash(user, book); }
}
