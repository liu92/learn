package org.learn.boot.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyAMQPConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 22:43
 * History:
 * @<version> 1.0
 */
@Configuration
public class MyAmqpConfig {

    @Bean
    public MessageConverter messageConverter(){
       return  new Jackson2JsonMessageConverter();
    }






















}
