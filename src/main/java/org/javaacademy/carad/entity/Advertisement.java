package org.javaacademy.carad.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Advertisement {
    private int id;
    @NonNull
    private String brandName;
    @NonNull
    private String color;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String model;
    @NonNull
    private LocalDate localDate;
}
