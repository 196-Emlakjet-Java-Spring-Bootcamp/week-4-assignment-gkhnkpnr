package com.example.week4assigmentconsumer.service;

import com.example.week4assigmentconsumer.dao.UserRepository;
import com.example.week4assigmentconsumer.dto.UserDTO;
import com.example.week4assigmentconsumer.helper.UserDtoToEntityHelper;
import com.example.week4assigmentconsumer.helper.emailGeneratorHelper;
import com.example.week4assigmentconsumer.helper.firstNameHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "${queue.name}")
    public void createUser(@Payload UserDTO userDTO){
        userDTO.setFirstName(firstNameHelper.generateFirstName());
        userDTO.setLastName(firstNameHelper.generateFirstName());
        userDTO.setEmail(emailGeneratorHelper.generateEmail(userDTO.getFirstName(),userDTO.getLastName()));
        userRepository.save(UserDtoToEntityHelper.transform(userDTO));
    }
}
