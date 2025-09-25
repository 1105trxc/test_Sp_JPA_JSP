package com.testd1.service;
import com.testd1.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VideoService {
    Page<Video> findAll(Pageable pageable);
    Optional<Video> findById(String id);
    Video save(Video v);
    void deleteById(String id);
}