package org.learn.boot.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: HelloSender
 * @Description: 消息发送
 * @Author: lin
 * @Date: 2019/3/24 20:27
 * History:
 * @<version> 1.0
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(){
        String context = "hello" + new Date();
        System.out.println("SendMessage:" + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
