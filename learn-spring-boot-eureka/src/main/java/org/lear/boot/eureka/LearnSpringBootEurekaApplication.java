package org.lear.boot.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1、配置eureka 信息
 * 2、@EnableEurekaServer 启用注册中心
 * @author lin
 */
@EnableEurekaServer
@SpringBootApplication
public class LearnSpringBootEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootEurekaApplication.class, args);
	}

}
