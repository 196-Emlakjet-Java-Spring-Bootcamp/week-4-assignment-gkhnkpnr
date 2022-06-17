package com.example.week4assigmentconsumer.service;

import com.example.week4assigmentconsumer.dao.AdvertisementRepository;
import com.example.week4assigmentconsumer.dto.AdvertisementDTO;
import com.example.week4assigmentconsumer.helper.AdvertisementDtoToEntityHelper;
import com.example.week4assigmentconsumer.helper.descriptionHelper;
import com.example.week4assigmentconsumer.helper.titleHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
    private AdvertisementRepository advertisementRepository;
    private AdvertisementDtoToEntityHelper helper;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertisementRepository,AdvertisementDtoToEntityHelper helper) {
        this.advertisementRepository = advertisementRepository;
        this.helper = helper;
    }

    @RabbitListener(queues = "${advertisement-queue.name}")
    public void createAdvertisement(AdvertisementDTO advertisementDTO) throws InterruptedException{
        Thread.sleep(60*1000);
        advertisementDTO.setDescription(descriptionHelper.generateDescription());
        advertisementDTO.setTitle(titleHelper.generateTitle());
        advertisementRepository.save(helper.transform(advertisementDTO));
    }

}
