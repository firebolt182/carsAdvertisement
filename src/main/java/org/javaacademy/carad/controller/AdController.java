package org.javaacademy.carad.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.carad.dto.AdvertisementDto;
import org.javaacademy.carad.entity.Advertisement;
import org.javaacademy.carad.service.AdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ad")
@RequiredArgsConstructor
public class AdController {
    private final AdService adService;

    @PostMapping("/new")
    public ResponseEntity createAd(@RequestBody AdvertisementDto body) {
        adService.createAd(body);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/get")
    public List<Advertisement> findAdByDate(@RequestParam(required = false) LocalDate date) {
        if (date == null) {
            return adService.findAll();
        }
        return adService.findAdByDate(date);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAd(@PathVariable int id) {
        adService.deleteById(id);
    }
}
