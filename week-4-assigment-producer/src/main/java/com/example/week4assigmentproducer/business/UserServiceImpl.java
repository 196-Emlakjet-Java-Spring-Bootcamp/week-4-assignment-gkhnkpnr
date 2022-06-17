package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dto.UserDTO;
import com.example.week4assigmentproducer.entity.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public UserServiceImpl(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void createUser(@Payload UserDTO userDTO) {
        rabbitTemplate.convertAndSend(this.queue.getName(),userDTO);
    }
}
