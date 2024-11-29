package org.javaacademy.caravito.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Announcement {
    private long id;
    private CarBrand brand;
    private Color color;
    private BigDecimal price;
}
