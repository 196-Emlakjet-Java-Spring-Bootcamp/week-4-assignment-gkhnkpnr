package com.example.week4assigmentconsumer.helper;

import com.example.week4assigmentconsumer.dao.AdvertisementRepository;
import com.example.week4assigmentconsumer.dao.UserRepository;
import com.example.week4assigmentconsumer.dto.AdvertisementDTO;
import com.example.week4assigmentconsumer.entity.Advertisement;
import com.example.week4assigmentconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Component
public class AdvertisementDtoToEntityHelper {
    private UserRepository userRepository;

    @Autowired
    public AdvertisementDtoToEntityHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Advertisement transform(AdvertisementDTO advertisementDTO){
        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(advertisementDTO.getDescription());
        advertisement.setTitle(advertisementDTO.getTitle());
        Random random = new Random();
        Long randomUserId = Long.valueOf(random.nextInt(userRepository.getNumberOfUsers()));
        advertisement.setUser(new User(randomUserId));
        advertisement.setCreatedAt(LocalDateTime.now());
        return advertisement;
    }
}
