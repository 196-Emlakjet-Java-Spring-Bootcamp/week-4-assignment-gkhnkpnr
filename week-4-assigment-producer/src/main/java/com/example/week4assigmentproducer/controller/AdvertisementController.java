package com.example.week4assigmentproducer.controller;

import com.example.week4assigmentproducer.business.AdvertisementService;
import com.example.week4assigmentproducer.dto.AdvertisementDTO;
import com.example.week4assigmentproducer.entity.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {
    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO){
        advertisementService.createAdvertisement(advertisementDTO);
    }

    @GetMapping("/CreatedAtBetween")
    public List<Advertisement> findAdvertisementsByCreatedAtBetween(@RequestParam(name = "startDate") LocalDateTime startDate, @RequestParam("endDate") LocalDateTime endDate){
        return advertisementService.findAdvertisementsByCreatedAtBetween(startDate,endDate);
    }

    @GetMapping("/CreatedAtASC")
    public List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time){
        return advertisementService.findAdvertisementsByCreatedAtOrderByCreatedAtAsc(time);
    }

    @GetMapping("/CreatedAtDESC")
    public List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time){
        return advertisementService.findAdvertisementsByCreatedAtOrderByCreatedAtDesc(time);
    }

    @GetMapping("/title")
    public List<Advertisement> findAdvertisementsByTitleContainingIgnoreCase(String title){
        return advertisementService.findAdvertisementsByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/description")
    public List<Advertisement> findAdvertisementsByDescriptionContainingIgnoreCase(String description){
        return advertisementService.findAdvertisementsByDescriptionContainingIgnoreCase(description);
    }
}
