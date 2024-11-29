package org.javaacademy.caravito.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.javaacademy.caravito.entity.Announcement;
import org.javaacademy.caravito.entity.CarBrand;
import org.javaacademy.caravito.entity.Color;
import org.javaacademy.caravito.service.AnnouncementService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/announcement")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Integer id) {
        return announcementService.getById(id).orElseThrow();
    }

    @GetMapping
    public List<Announcement> getAllAnnouncement() {
        return announcementService.getAll();
    }

    @GetMapping("/param")
    public List<Announcement> getAnnouncementByParam(@RequestParam(required = false) CarBrand brand,
                                                     @RequestParam(required = false) Color color,
                                                     @RequestParam(required = false) BigDecimal price) {
        return announcementService.getByParam(brand, color, price);
    }

    @GetMapping("/brand")
    public List<Announcement> getAnnouncementByCarBrand(@RequestParam CarBrand brand) {
        return announcementService.getByCarBrand(brand);
    }

    @PostMapping
    public void createAnnouncement(@RequestBody Announcement announcement) {
        announcementService.save(announcement);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAnnouncementById(@PathVariable Integer id) {
        return announcementService.deleteById(id);
    }

}
