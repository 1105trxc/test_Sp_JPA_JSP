package com.testd1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.testd1.entity.Video;
import com.testd1.repository.CategoryRepository_23110243;
import com.testd1.service.VideoService;

@Controller
@RequestMapping("/admin/videos")
public class AdminVideoController {

    private final VideoService videoService;
    private final CategoryRepository_23110243 categoryRepository;

    @Value("${app.videos.page-size:6}")
    private int pageSize;

    public AdminVideoController(VideoService videoService, CategoryRepository_23110243 categoryRepository) {
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
    public String save(Video video, RedirectAttributes ra) {
        boolean isNew = !videoService.findById(video.getId()).isPresent();
        try {
            if (isNew && video.getId() != null && videoService.findById(video.getId()).isPresent()) {
                ra.addFlashAttribute("error", "ID đã tồn tại. Vui lòng chọn ID khác.");
                return "redirect:/admin/videos";
            }
            videoService.save(video);
            ra.addFlashAttribute("msg", isNew ? "Thêm mới video thành công." : "Cập nhật video thành công.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Lỗi khi lưu video: " + e.getMessage());
        }
        return "redirect:/admin/videos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,
                       @RequestParam(defaultValue = "0") int page,
                       Model model, RedirectAttributes ra) {
        Video v = videoService.findById(id).orElse(null);
        if (v == null) {
            ra.addFlashAttribute("error", "Không tìm thấy video với ID: " + id);
            return "redirect:/admin/videos";
        }
        model.addAttribute("video", v);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("page", videoService.findAll(PageRequest.of(page, pageSize)));
        return "admin/videos/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes ra) {
        if (!videoService.findById(id).isPresent()) {
            ra.addFlashAttribute("error", "Không tìm thấy video để xoá với ID: " + id);
            return "redirect:/admin/videos";
        }
        videoService.deleteById(id);
        ra.addFlashAttribute("msg", "Đã xoá video thành công.");
        return "redirect:/admin/videos";
    }
}