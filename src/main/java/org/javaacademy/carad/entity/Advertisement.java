package org.javaacademy.carad.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

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
