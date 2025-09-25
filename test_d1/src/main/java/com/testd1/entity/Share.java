package com.testd1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Shares")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId")
    private Integer id;

    @Column(name = "Emails", length = 50)
    private String emails;

    @Column(name = "SharedDate")
    private LocalDate sharedDate;

    @ManyToOne
    @JoinColumn(name = "Username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;
}