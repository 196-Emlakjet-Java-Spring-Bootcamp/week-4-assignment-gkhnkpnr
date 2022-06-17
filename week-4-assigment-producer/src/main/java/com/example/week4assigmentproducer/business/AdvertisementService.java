package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dto.AdvertisementDTO;
import com.example.week4assigmentproducer.entity.Advertisement;

import java.time.LocalDateTime;
import java.util.List;

public interface AdvertisementService {
    void createAdvertisement(AdvertisementDTO advertisementDTO);
    List<Advertisement> findAdvertisementsByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time);
    List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time);
    List<Advertisement> findAdvertisementsByTitleContainingIgnoreCase(String title);
    List<Advertisement> findAdvertisementsByDescriptionContainingIgnoreCase(String description);
}
