package com.testd1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Category")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private Integer id;

    @Column(name = "Categoryname", length = 100)
    private String name;

    @Column(name = "Categorycode", length = 100)
    private String code;

    @Column(name = "Images", length = 500)
    private String images;

    @Column(name = "Status")
    private Boolean status;
}