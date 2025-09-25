package com.testd1.repository;

import com.testd1.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Integer> {
}