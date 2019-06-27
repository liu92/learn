package org.learn.boot.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitConfig
 * @Description: RabbitMQ配置
 * @Author: lin
 * @Date: 2019/6/24 23:00
 * History:
 * @<version> 1.0
 */
@Configuration
public class RabbitConfig {

  @Bean
  public Queue queue(){
   return new Queue("hello");
  }

}
