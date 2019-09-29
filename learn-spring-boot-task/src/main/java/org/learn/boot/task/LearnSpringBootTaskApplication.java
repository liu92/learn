package org.learn.boot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lin
 * @EnableAsync 开启异步任务
 * @EnableScheduling 基于注解的定时任务
 */
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class LearnSpringBootTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootTaskApplication.class, args);
	}

}
