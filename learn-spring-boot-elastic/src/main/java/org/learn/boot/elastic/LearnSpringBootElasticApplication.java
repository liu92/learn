package org.learn.boot.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 默认支持两种默认技术来和ES交互
 * 1、jest (默认不生效，如果要使其生效需要导入 jest的工具包 io.searchbox.client.JestClient)
 * 2、SpringData elasticsearch
 *      1)、Client 节点信息clusterNodes ; clusterName
 *      2)、ElasticsearchTemplate 操作es。
 *        spring在整合很多技术时候都会引入相应的Template. 比如 RedisTemplate ,RabbitMQTemplate等等
 *      3)、编写一个ElasticsearchRepository子接口来操作es
 *          最上层是Repository 或者使用 CrudRepository来操作es
 *
 *   a、编写一个ElasticsearchRepository 子接口
 *
 * @author lin
 */
@SpringBootApplication
public class LearnSpringBootElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootElasticApplication.class, args);
	}

}
