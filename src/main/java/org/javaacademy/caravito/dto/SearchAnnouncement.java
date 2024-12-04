package org.javaacademy.caravito.dto;

import lombok.Data;
import org.javaacademy.caravito.announcement.CarBrand;
import org.javaacademy.caravito.announcement.Color;

import java.math.BigDecimal;

@Data
public class SearchAnnouncement {
    private CarBrand brand;
    private Color color;
    private BigDecimal price;
}
