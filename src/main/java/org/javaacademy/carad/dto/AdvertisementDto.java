package org.javaacademy.carad.dto;

import lombok.NonNull;
import lombok.Value;
import org.javaacademy.carad.entity.Car;

import java.time.LocalDate;

@Value
public class AdvertisementDto {
    int id;
    String brandName;
    String color;
    double price;
    String model;
    LocalDate localDate;
}
