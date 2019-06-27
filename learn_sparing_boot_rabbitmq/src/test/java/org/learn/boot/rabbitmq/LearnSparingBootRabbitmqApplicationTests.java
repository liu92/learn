package org.learn.boot.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.boot.rabbitmq.hello.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSparingBootRabbitmqApplicationTests {
	@Autowired
	private HelloSender helloSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  hello(){
       helloSender.sendMessage();
	}
}
