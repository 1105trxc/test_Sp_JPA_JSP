package com.testd1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Videos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Video {
    @Id
    @Column(name = "VideoId", length = 50, nullable = false)
    private String id;

    @Column(name = "Title", length = 200)
    private String title;

    @Column(name = "Poster", length = 50)
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
}