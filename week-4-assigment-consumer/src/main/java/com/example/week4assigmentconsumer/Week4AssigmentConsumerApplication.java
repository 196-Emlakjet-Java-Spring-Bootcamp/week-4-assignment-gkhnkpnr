package com.example.week4assigmentconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Week4AssigmentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week4AssigmentConsumerApplication.class, args);
	}

}
