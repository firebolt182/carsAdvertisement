package org.javaacademy.carad.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.carad.dto.AdvertisementDto;
import org.javaacademy.carad.dto.CarDto;
import org.javaacademy.carad.entity.Advertisement;
import org.javaacademy.carad.entity.Car;
import org.javaacademy.carad.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdService {
    private final AdRepository adRepository;

    public void createAd(AdvertisementDto dto) {
        LocalDate date = dto.getLocalDate() == null ? LocalDate.now() : dto.getLocalDate();
        Advertisement advertisement = new Advertisement(
                dto.getBrandName(),
                dto.getColor(),
                dto.getPrice(),
                dto.getModel(),
                date);
        adRepository.add(advertisement);
    }

    public List<Advertisement> findAdByDate(LocalDate localDate) {
        return adRepository.findAdByDate(localDate);
    }

    public List<Advertisement> findCarsByProperties(String brandName, String color,
                                          BigDecimal price, String model) {
        return adRepository.findCarsByProperties(brandName, color, price, model);
    }

    public List<Advertisement> findAll() {
        return adRepository.findAll();
    }

    public void deleteById(int id) {
        adRepository.deleteById(id);
    }


    public Advertisement findById(int id) {
        return adRepository.findById(id);
    }
}
