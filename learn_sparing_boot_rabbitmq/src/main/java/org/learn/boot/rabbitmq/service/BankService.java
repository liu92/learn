package org.learn.boot.rabbitmq.service;

import org.learn.boot.rabbitmq.po.Bank;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 监听消息队列 ,通过注解的方式
 * @ClassName: BankService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 7:42
 * History:
 * @<version> 1.0
 */
@Service
public class BankService {

    /**
     * 这样就表示这个队列一有消息，下面这里就会接收到消息进行打印
     */
    @RabbitListener(queues = "lin.news")
    public void receiver(Bank bank){
        System.out.println("收到消息："+ bank);
    }
}
