package org.javaacademy.carad.repository;

import org.javaacademy.carad.entity.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarRepository {
    private Map<Integer, Car> cars = new LinkedHashMap<>();

    /*
     * (если указано одно поле, то поиск по одному полю.
     *  Если указано два и более то сочетание этих полей):
     *  имя бренда, цвет, цена, модель
     */
    {
        cars.put(ID, new Car("brand", "color", new BigDecimal("23"), "model"));
        cars.put(ID, new Car("vaz", "red", BigDecimal.valueOf(100), "2109"));
        cars.put(ID, new Car("brand", "blue", BigDecimal.valueOf(10), "model"));
        cars.put(ID, new Car("bmw", "black", BigDecimal.valueOf(10), "model"));
        cars.put(ID, new Car("vaz", "red", BigDecimal.valueOf(100), "2109"));
    }

    public void add(Car car) {
        cars.put(car.getId(), car);
    }

    public List<Car> findCarsByProperties(String brandName, String color, BigDecimal price, String model) {
        if (brandName == null && color == null && price == null && model == null) {
            return new ArrayList<>();
        }
        List<Car> brandCar = new ArrayList<>(cars.values().stream()
                .filter(car ->
                        (car.getBrandName().equals(brandName) ||  brandName == null) &&
                        (car.getColor().equals(color) ||  color == null) &&
                        (car.getPrice().equals(price) ||  price == null) &&
                        (car.getModel().equals(model) ||  model == null))
                .toList());
        return brandCar;
    }

    public List<Car> printAllCars() {
        return new ArrayList<>(cars.values());
    }

    public Car findById(int id) {
        return cars.get(id);
    }
}
