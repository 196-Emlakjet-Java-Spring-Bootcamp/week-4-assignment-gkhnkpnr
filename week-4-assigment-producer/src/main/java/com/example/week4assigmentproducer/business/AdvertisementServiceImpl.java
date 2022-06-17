package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dto.AdvertisementDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{
    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public AdvertisementServiceImpl(RabbitTemplate rabbitTemplate, Queue queue) {
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
}
