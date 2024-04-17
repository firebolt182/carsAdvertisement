package org.javaacademy.carad.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.carad.dto.AdvertisementDto;
import org.javaacademy.carad.dto.CarDto;
import org.javaacademy.carad.entity.Car;
import org.javaacademy.carad.service.AdService;
import org.javaacademy.carad.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/new")
    public ResponseEntity createCar(@RequestBody CarDto body) {
        carService.createCar(body);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/get")
    public List<Car> findCarsByProperties(
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) String model) {
        CarDto dto = new CarDto(brandName, color, price, model);
        return carService.findCarsByProperties(dto);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable int id) {
        return carService.findById(id);
    }

    @GetMapping("/get/all")
    public List<Car> getAllCars() {
        return carService.printAllCars();
    }
}
