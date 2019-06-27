package org.learn.boot.mybatis.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.learn.boot.mybatis.demo.mapper")
@SpringBootApplication
public class LearnSpringBootMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootMybatisDemoApplication.class, args);
	}

}
