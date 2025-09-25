package com.testd1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.testd1.entity.Video;
import com.testd1.repository.CategoryRepository;
import com.testd1.service.VideoService;

@Controller
@RequestMapping("/admin/videos")
public class AdminVideoController {

    private final VideoService videoService;
    private final CategoryRepository categoryRepository;

    @Value("${app.videos.page-size:6}")
    private int pageSize;

    public AdminVideoController(VideoService videoService, CategoryRepository categoryRepository) {
        this.videoService = videoService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("page", videoService.findAll(PageRequest.of(page, pageSize)));
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/videos/index";
    }

    @PostMapping("/save")
    public String save(Video video) {
        videoService.save(video);
        return "redirect:/admin/videos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,
                       @RequestParam(defaultValue = "0") int page,
                       Model model) {
        Video v = videoService.findById(id).orElse(new Video());
        model.addAttribute("video", v);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("page", videoService.findAll(PageRequest.of(page, pageSize)));
        return "admin/videos/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos";
    }
}
