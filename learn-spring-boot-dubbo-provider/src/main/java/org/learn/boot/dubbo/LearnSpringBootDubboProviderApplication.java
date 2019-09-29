package org.learn.boot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册到注册中心
 * 2、引入dubbo-spring-boot-starter 和 zkClient依赖
 * 3、 配置dubbo的扫描包和组注册中心地址
 * 4、使用@Service 服务
 * @author lin
 */
@SpringBootApplication
public class LearnSpringBootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootDubboProviderApplication.class, args);
	}

}
