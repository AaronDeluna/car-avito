package org.javaacademy.caravito.service;

import org.javaacademy.caravito.entity.Announcement;
import org.javaacademy.caravito.entity.CarBrand;
import org.javaacademy.caravito.entity.Color;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AnnouncementService {
    private final Map<Integer, Announcement> announcementStorage = new HashMap<>();
    private int count;

    public void save(Announcement announcement) {
        count++;
        announcement.setId(count);
        announcementStorage.put(count, announcement);
    }

    public List<Announcement> getAll() {
        return announcementStorage.values().stream()
                .toList();
    }

    public Optional<Announcement> getById(Integer id) {
        return Optional.ofNullable(announcementStorage.get(id));
    }

    public boolean deleteById(Integer id) {
        return announcementStorage.remove(id) != null;
    }

    public List<Announcement> getByCarBrand(CarBrand brand) {
        return announcementStorage.values().stream()
                .filter(announcement -> announcement.getBrand().equals(brand))
                .toList();
    }

    public List<Announcement> getByParam(CarBrand brand, Color color, BigDecimal price) {
        return announcementStorage.values().stream()
                .filter(announcement -> (brand == null || announcement.getBrand() == brand))
                .filter(announcement -> (color == null || announcement.getColor() == color))
                .filter(announcement -> (price == null || announcement.getPrice().compareTo(price) == 0))
                .toList();
    }

}
