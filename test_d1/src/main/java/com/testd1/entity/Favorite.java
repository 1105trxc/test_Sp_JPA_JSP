package com.testd1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Favorites")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private Integer id;

    @Column(name = "LikedDate")
    private LocalDate likedDate;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;
}