package com.example.week4assigmentproducer.business;

import com.example.week4assigmentproducer.dto.UserDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public UserServiceImpl(RabbitTemplate rabbitTemplate, @Qualifier("userQueue") Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        int i = 1;
        while (i < 51){
            rabbitTemplate.convertAndSend(this.queue.getName(),userDTO);
            i++;
        }

    }
}
