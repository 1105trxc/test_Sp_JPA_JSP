package com.testd1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.testd1.entity.Video;
import com.testd1.repository.VideoRepository_23110243;
import com.testd1.service.VideoService;

import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository_23110243 repo;

    public VideoServiceImpl(VideoRepository_23110243 repo) {
        this.repo = repo;
    }

    @Override
    public Page<Video> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Video> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Video save(Video v) {
        if (v.getViews() == null) v.setViews(0);
        if (v.getActive() == null) v.setActive(true);
        return repo.save(v);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}