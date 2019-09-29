package org.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 1、从注册中心中发现服务 @EnableDiscoveryClient ，这个注解是开始发现功能
 *
 *
 * @author lin
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LearnSpringCloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringCloudConsumerApplication.class, args);
	}

	/**
	 * 调用服务通过RestTemplate，这个是来发送HTTP请求的
	 * @LoadBalanced 使用负载均衡机制
	 * @return
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
      return new RestTemplate();
	}
}
