package com.sgraphwebsite.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String fullname;
    private int phone;
    private String passwd;
    private LocalDateTime signup_date;
    private LocalDateTime last_login;
    private Boolean is_admin; // changed to wrapper for null-safety

    // Getters, Setters, Relationships
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }
    public String getPasswd() { return passwd; }
    public void setPasswd(String passwd) { this.passwd = passwd; }
    public LocalDateTime getSignup_date() { return signup_date; }
    public void setSignup_date(LocalDateTime signup_date) { this.signup_date = signup_date; }
    public LocalDateTime getLast_login() { return last_login; }
    public void setLast_login(LocalDateTime last_login) { this.last_login = last_login; }

    // Admin helpers compatible with EL and existing code
    public Boolean getIs_admin() { return is_admin; }
    public boolean isIs_admin() { return Boolean.TRUE.equals(is_admin); }
    public void setIs_admin(Boolean is_admin) { this.is_admin = is_admin; }
}