package com.testd1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.testd1.service.VideoService;
import com.testd1.repository.ShareRepository_23110243;
import com.testd1.repository.FavoriteRepository_23110243;
import com.testd1.repository.CategoryRepository_23110243;
import com.testd1.repository.VideoRepository_23110243;
import com.testd1.entity.Category;
import com.testd1.entity.Video;

import java.util.*;

@Controller
public class HomeController {

    private final VideoService videoService;
    private final ShareRepository_23110243 shareRepository;
    private final FavoriteRepository_23110243 favoriteRepository;
    private final CategoryRepository_23110243 categoryRepository;
    private final VideoRepository_23110243 videoRepository;

    @Value("${app.videos.page-size:6}")
    private int pageSize;

    public HomeController(VideoService videoService, ShareRepository_23110243 shareRepository, FavoriteRepository_23110243 favoriteRepository, CategoryRepository_23110243 categoryRepository, VideoRepository_23110243 videoRepository) {
        this.videoService = videoService;
        this.shareRepository = shareRepository;
        this.favoriteRepository = favoriteRepository;
        this.categoryRepository = categoryRepository;
        this.videoRepository = videoRepository;
    }

    @GetMapping({"/", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/products")
    public String products(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("page", videoService.findAll(PageRequest.of(page, pageSize)));
        return "products";
    }

    @GetMapping("/products/{id}")
    public String videoDetail(@PathVariable("id") String id, Model model) {
        var videoOpt = videoService.findById(id);
        if (videoOpt.isEmpty()) {
            model.addAttribute("error", "Không tìm thấy video");
            return "video-detail";
        }
        var video = videoOpt.get();
        long shareCount = shareRepository.countByVideo_Id(video.getId());
        long likeCount = favoriteRepository.countByVideo_Id(video.getId());
        model.addAttribute("video", video);
        model.addAttribute("shareCount", shareCount);
        model.addAttribute("likeCount", likeCount);
        return "video-detail";
    }

    @GetMapping("/categories")
    public String videosByCategory(Model model) {
        var categories = categoryRepository.findAll();
        List<Map<String, Object>> categoryList = new ArrayList<>();
        for (Category cat : categories) {
            Map<String, Object> catMap = new HashMap<>();
            catMap.put("id", cat.getId());
            catMap.put("name", cat.getName());
            List<Video> videos = videoService.findAll(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
            List<Map<String, Object>> videoList = new ArrayList<>();
            for (Video v : videoRepository.findByCategory_Id(cat.getId())) {
                Map<String, Object> vMap = new HashMap<>();
                vMap.put("id", v.getId());
                vMap.put("title", v.getTitle());
                vMap.put("poster", v.getPoster());
                vMap.put("views", v.getViews());
                vMap.put("description", v.getDescription());
                vMap.put("category", cat.getName());
                vMap.put("shareCount", shareRepository.countByVideo_Id(v.getId()));
                vMap.put("likeCount", favoriteRepository.countByVideo_Id(v.getId()));
                videoList.add(vMap);
            }
            catMap.put("videos", videoList);
            catMap.put("videoCount", videoList.size());
            categoryList.add(catMap);
        }
        model.addAttribute("categories", categoryList);
        return "categories";
    }
}