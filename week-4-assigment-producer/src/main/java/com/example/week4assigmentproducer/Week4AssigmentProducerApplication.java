package com.example.week4assigmentproducer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Week4AssigmentProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week4AssigmentProducerApplication.class, args);
    }

}
