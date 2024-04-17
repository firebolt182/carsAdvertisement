package org.javaacademy.carad.repository;

import lombok.Getter;
import org.javaacademy.carad.entity.Advertisement;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdRepository {
    private static int ID = 0;
    @Getter
    private Map<Integer, Advertisement> advertisements = new LinkedHashMap<>();

    public void add(Advertisement advertisement) {
        advertisement.setId(++ID);
        advertisements.put(ID, advertisement);
    }

    public List<Advertisement> findAdByDate(LocalDate localDate) {
        List<Advertisement> dateList = new ArrayList<>(advertisements.values().stream()
                .filter(ad -> ad.getLocalDate().equals(localDate)).toList());
        return dateList;
    }

    public List<Advertisement> findAll() {
        return new ArrayList<>(advertisements.values());
    }

    public void deleteById(int id) {
        /*Advertisement advertisement = advertisements.values().stream()
                        .filter(ad -> ad.getId() == id).findFirst().orElseThrow();*/
        advertisements.remove(id);
    }

    public List<Advertisement> findCarsByProperties(String brandName, String color, BigDecimal price, String model) {
        if (brandName == null && color == null && price == null && model == null) {
            return new ArrayList<>();
        }
        List<Advertisement> brandCar = new ArrayList<>(advertisements.values().stream()
                .filter(ad ->
                        (ad.getBrandName().equals(brandName) ||  brandName == null) &&
                                (ad.getColor().equals(color) ||  color == null) &&
                                (ad.getPrice().equals(price) ||  price == null) &&
                                (ad.getModel().equals(model) ||  model == null))
                .toList());
        return brandCar;
    }

    public Advertisement findById(int id) {
        return advertisements.get(id);
    }
}
