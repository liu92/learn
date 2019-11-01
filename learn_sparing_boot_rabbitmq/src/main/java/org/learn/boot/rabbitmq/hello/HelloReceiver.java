package org.learn.boot.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloReceiver
 * @Description: 消息接收者
 * @Author: lin
 * @Date: 2019/3/24 23:32
 * History:
 * @<version> 1.0
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
      System.out.println("Receiver:"+ hello);
    }
}
