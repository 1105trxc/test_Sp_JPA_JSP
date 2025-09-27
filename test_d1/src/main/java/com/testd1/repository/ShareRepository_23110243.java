package com.testd1.repository;

import com.testd1.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository_23110243 extends JpaRepository<Share, Integer> {
    long countByVideo_Id(String videoId);
}