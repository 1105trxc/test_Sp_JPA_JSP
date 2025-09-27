package com.testd1.repository;

import com.testd1.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository_23110243 extends JpaRepository<Video, String> {
    List<Video> findByCategory_Id(Integer categoryId);
}