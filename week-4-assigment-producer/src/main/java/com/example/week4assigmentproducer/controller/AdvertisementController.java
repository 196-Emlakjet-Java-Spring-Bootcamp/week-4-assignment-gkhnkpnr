package com.example.week4assigmentproducer.controller;

import com.example.week4assigmentproducer.business.AdvertisementService;
import com.example.week4assigmentproducer.dto.AdvertisementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertisement")
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
}