package org.javaacademy.caravito.announcement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    private long id;
    private CarBrand brand;
    private Color color;
    private BigDecimal price;
}
