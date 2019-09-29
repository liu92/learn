package org.learn.boot.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.boot.rabbitmq.hello.HelloSender;
import org.learn.boot.rabbitmq.po.Bank;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSparingBootRabbitmqApplicationTests {
	@Autowired
	private HelloSender helloSender;

	@Resource
    private RabbitTemplate rabbitTemplate;

	@Resource
	private AmqpAdmin amqpAdmin;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  hello(){
       helloSender.sendMessage();
	}


	@Test
	public void create(){
		// 使用amqpAdmin 创建exchange
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

		// 创建队列
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

		//绑定规则
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,
				"amqpadmin.exchange", "amqp.test",null));
	}

	/**
	 * 1、测试点对点
	 */
	@Test
	public void  testDirect(){
       //Messge需要自己构造一个，定义消息体内容和消息头
	   //rabbitTemplate.send(exchange, routingKey, message);

	   // object 默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
       //rabbitTemplate.convertAndSend(exchange, routingKey, message);
		Map<String, Object> map =new HashMap<>(16);
		map.put("msg","点对点消息测试");
		map.put("data", Arrays.asList("test",123,true));
		//如果不进行序列化处理，那么对象会被默认的序列化以后发送出去
		rabbitTemplate.convertAndSend("exchange.direct", "lin.news", new Bank("2324","招商银行"));
	}

	/**
	 * 接收消息
	 */
	@Test
	public void testReceiver(){
		Object o = rabbitTemplate.receiveAndConvert("lin.news");
		System.out.println("对象是什么类型："+o.getClass());
		System.out.println("接收消息："+o);
		// 结果：
        //对象是什么类型：class java.util.HashMap
        //接收消息：{msg=点对点消息测试, data=[test, 123, true]}
	}

	@Test
	public void testFanout(){
		rabbitTemplate.convertAndSend("exchange.fanout","", new Bank("13f3452", "中国银行"));
	}
}
