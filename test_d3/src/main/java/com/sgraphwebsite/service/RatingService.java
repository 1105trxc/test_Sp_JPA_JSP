package com.sgraphwebsite.service;

import org.springframework.stereotype.Service;

import com.sgraphwebsite.repository.RatingRepository;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    // Business Logic methods can be added here
}