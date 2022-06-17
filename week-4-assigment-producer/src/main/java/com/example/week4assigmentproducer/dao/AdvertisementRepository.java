package com.example.week4assigmentproducer.dao;

import com.example.week4assigmentproducer.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAdvertisementsByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time);
    List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time);
    List<Advertisement> findAdvertisementsByTitleContainingIgnoreCase(String title);
    List<Advertisement> findAdvertisementsByDescriptionContainingIgnoreCase(String description);
}
