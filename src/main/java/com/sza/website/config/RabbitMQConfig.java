package com.sza.website.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.sza.website.constant.MQPrefixConst.*;
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue emailQueue() {return new Queue(NOTICE_QUEUE);}
}
