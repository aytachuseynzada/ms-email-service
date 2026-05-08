package com.example.msemail.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue smsQueue() {
        return QueueBuilder.durable("sms.queue")
                .build();
    }

    @Bean
    public DirectExchange smsExchange() {
        return new DirectExchange("sms.exchange");
    }

    @Bean
    public Binding smsBinding() {
        return BindingBuilder
                .bind(smsQueue())
                .to(smsExchange())
                .with("sms.key");
    }
}
