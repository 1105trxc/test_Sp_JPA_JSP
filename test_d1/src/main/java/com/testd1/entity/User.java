package com.testd1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id
    @Column(name = "Username", length = 50, nullable = false)
    private String username;

    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Column(name = "Fullname", length = 50)
    private String fullname;

    @Column(name = "Email", length = 150)
    private String email;

    @Column(name = "Admin")
    private Boolean admin;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Images", length = 500)
    private String images;
}