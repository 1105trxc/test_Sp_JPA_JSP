package com.testd1.repository;

import com.testd1.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository_23110243 extends JpaRepository<Favorite, Integer> {
    long countByVideo_Id(String videoId);
}