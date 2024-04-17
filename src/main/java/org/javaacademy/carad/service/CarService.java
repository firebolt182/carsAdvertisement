package org.javaacademy.carad.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.carad.dto.AdvertisementDto;
import org.javaacademy.carad.dto.CarDto;
import org.javaacademy.carad.entity.Car;
import org.javaacademy.carad.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> findCarsByProperties(CarDto dto) {
        return carRepository.findCarsByProperties(dto.getBrandName(), dto.getColor(),
                dto.getPrice(), dto.getModel());
    }

    public void createCar(CarDto dto) {
        String brandName = dto.getBrandName() == null ? "null" : dto.getBrandName();
        String color = dto.getColor() == null ? "null" : dto.getColor();
        BigDecimal price = dto.getPrice() == null  ? BigDecimal.ZERO : dto.getPrice();
        String model = dto.getModel() == null ? "null" : dto.getModel();
        Car car = new Car(brandName, color, price, model);
        carRepository.add(car);
    }

    public List<Car> printAllCars() {
        return carRepository.printAllCars();
    }

    public Car findById(int id) {
        return carRepository.findById(id);
    }
}
