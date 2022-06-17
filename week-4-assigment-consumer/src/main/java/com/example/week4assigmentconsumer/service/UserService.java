package com.example.week4assigmentconsumer.service;

import com.example.week4assigmentconsumer.dao.UserRepository;
import com.example.week4assigmentconsumer.dto.UserDTO;
import com.example.week4assigmentconsumer.entity.User;
import com.example.week4assigmentconsumer.helper.emailGeneratorHelper;
import com.example.week4assigmentconsumer.helper.firstNameHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "${queue.name}")
    public void createUser(@Payload UserDTO userDTO) throws InterruptedException{
        userDTO.setFirstName(firstNameHelper.generateFirstName());
        userDTO.setLastName(firstNameHelper.generateFirstName());
        userDTO.setEmail(emailGeneratorHelper.generateEmail(userDTO.getFirstName(),userDTO.getLastName()));
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
    }
}
