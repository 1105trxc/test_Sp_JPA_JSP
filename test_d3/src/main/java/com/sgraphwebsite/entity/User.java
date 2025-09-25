package com.sgraphwebsite.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String email;
    private String fullname;
    private int phone;
    private String passwd;
    private LocalDateTime signup_date;
    private LocalDateTime last_login;
    private boolean is_admin;
    // Getters, Setters, Relationships
}