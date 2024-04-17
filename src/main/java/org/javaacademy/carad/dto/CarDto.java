package org.javaacademy.carad.dto;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class CarDto {
    String brandName;
    String color;
    BigDecimal price;
    String model;
}
