package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dao.AdvertisementRepository;
import com.example.week4assigmentproducer.dto.AdvertisementDTO;
import com.example.week4assigmentproducer.entity.Advertisement;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    private AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository, RabbitTemplate rabbitTemplate, @Qualifier("advertisementQueue") Queue queue) {
        this.advertisementRepository = advertisementRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void createAdvertisement(AdvertisementDTO advertisementDTO) {
            int i = 1;
            while (i < 51){
                rabbitTemplate.convertAndSend(this.queue.getName(),advertisementDTO);
                i++;
            }
    }

    @Override
    public List<Advertisement> findAdvertisementsByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return advertisementRepository.findAdvertisementsByCreatedAtBetween(startDate,endDate);
    }

    @Override
    public List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtAsc(LocalDateTime time) {
        return advertisementRepository.findAdvertisementsByCreatedAtOrderByCreatedAtAsc(time);
    }

    @Override
    public List<Advertisement> findAdvertisementsByCreatedAtOrderByCreatedAtDesc(LocalDateTime time) {
        return advertisementRepository.findAdvertisementsByCreatedAtOrderByCreatedAtDesc(time);
    }

    @Override
    public List<Advertisement> findAdvertisementsByTitleContainingIgnoreCase(String title) {
        return advertisementRepository.findAdvertisementsByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Advertisement> findAdvertisementsByDescriptionContainingIgnoreCase(String description) {
        return advertisementRepository.findAdvertisementsByDescriptionContainingIgnoreCase(description);
    }
}
