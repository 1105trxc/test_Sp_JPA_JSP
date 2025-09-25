package com.testd1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.testd1.service.VideoService;

@Controller
public class HomeController {

    private final VideoService videoService;

    @Value("${app.videos.page-size:6}")
    private int pageSize;

    public HomeController(VideoService videoService) {
        this.videoService = videoService;
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
}
