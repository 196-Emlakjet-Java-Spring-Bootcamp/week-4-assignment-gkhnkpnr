package com.example.week4assigmentconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Value("${queue.name}")
    private String userQueue;

    @Value("${advertisement-queue.name}")
    private String advertisementQueue;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;

    @Bean
    public Queue userQueue() {
        return new Queue(userQueue, true);
    }

    @Bean
    public Queue advertisementQueue() {
        return new Queue(advertisementQueue, true);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    Binding userBinding(@Qualifier("userQueue") Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("user-routing");
    }

    @Bean
    Binding advertisementBinding(@Qualifier("advertisementQueue") Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("advertisement-routing");
    }

    @Bean
    MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
