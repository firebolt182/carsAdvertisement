package org.javaacademy.carad.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Value;

@Value
public class AdvertisementDto {
    int id;
    String brandName;
    String color;
    BigDecimal price;
    String model;
    LocalDate localDate;
}
