package com.sza.website.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.sza.website.constant.MQPrefixConst.*;
@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange noticeDirectExchange() {
        return new DirectExchange(NOTICE_EXCHANGE, true, false);
    }

    @Bean
    public Queue noticeQueue() {return new Queue(NOTICE_EMAIL_QUEUE, true, false, false, null);}

    @Bean
    public Binding bindNotice() {
        return BindingBuilder.bind(noticeQueue()).to(noticeDirectExchange()).with(NOTICE_EMAIL_ROUTINGKEY);
    }
}
