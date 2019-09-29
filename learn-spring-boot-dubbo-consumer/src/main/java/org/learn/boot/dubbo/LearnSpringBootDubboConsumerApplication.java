package org.learn.boot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入依赖
 * 2、配置dubbo的注册中心地址
 * 3、引用服务
 *
 *
 * @author lin
 */
@SpringBootApplication
public class LearnSpringBootDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootDubboConsumerApplication.class, args);
	}

}
