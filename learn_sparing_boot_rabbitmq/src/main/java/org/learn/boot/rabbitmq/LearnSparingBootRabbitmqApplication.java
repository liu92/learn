package org.learn.boot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *  1、RabbitAutoConfiguration
 *  2、有自动配置连接工厂 CachingConnectionFactory
 *  3、RabbitProperties 封装了 RabbitMQ的配置
 *  4、RabbitTemplate ： 给RabbitMQ 发送和接收消息
 *  5、AmqpAdmin ：RabbitMQ 系统管理功能组件
 *  6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 * @author lin
 */
// 开启基于注解的RabbitMQ模式
@EnableRabbit
@SpringBootApplication
public class LearnSparingBootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSparingBootRabbitmqApplication.class, args);
	}

}
