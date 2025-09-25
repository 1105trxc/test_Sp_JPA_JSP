package com.sgraphwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgraphwebsite.entity.Rating;
import com.sgraphwebsite.entity.RatingId;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {}
