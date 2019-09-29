package org.learn.boot.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.boot.dubbo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringBootDubboConsumerApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试远程调用
	 */
	@Test
	public void  testDubbo(){
      userService.hello();
	}
}
