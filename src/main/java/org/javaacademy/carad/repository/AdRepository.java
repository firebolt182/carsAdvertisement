package org.javaacademy.carad.repository;

import lombok.Getter;
import org.javaacademy.carad.entity.Advertisement;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdRepository {
    private static int ID = 0;
    @Getter
    private List<Advertisement> advertisements = new ArrayList<>();

    public void add(Advertisement advertisement) {
        advertisement.setId(++ID);
        advertisements.add(advertisement);
    }

    public List<Advertisement> findAdByDate(LocalDate localDate) {
        List<Advertisement> dateList = new ArrayList<>(advertisements.stream()
                .filter(ad -> ad.getLocalDate().equals(localDate)).toList());
        return dateList;
    }

    public List<Advertisement> findAll() {
        return advertisements;
    }

    public void deleteById(int id) {
        Advertisement advertisement = advertisements.stream()
                        .filter(ad -> ad.getId() == id).findFirst().orElseThrow();
        advertisements.remove(advertisement);
    }
}
