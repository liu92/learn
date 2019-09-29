package org.learn.boot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 *  @author lin
 * 1、这里使用mybatis操作数据库，
 *      使用注解版的Mybatis,
 * @MapperScan 指定需要扫描的mapper接口所在的包
 * 2、快速体验缓存
 *      a、开启基于注解的缓存 @EnableCaching
 *      b、标注缓存注解即可
 * 默认使用的是ConcurrentMapCacheManager == ConcurrentMapCache; 将数据保证在Concurrent<Object,Object>中
 * 开发使用缓存中间件， redis、ehcache.
 * 3、整合redis 作为缓存
 *    redis 是一个开源的，内存的数据结构存储系统，它可以用作数据库，缓存和消息中间件
 *     a、安装redis,
 *     b、引入redis的starter
 *     c、配置redis
 *     d、测试缓存
 *         原理： CacheManager == Cache 缓存组件来实际给缓存中存取数据
 *               1)、引入redis的starter, 容器中保存的是 RedisCacheManager;
 *               2)、RedisCacheManager 帮我们存储RedisCache 来作为缓存组件；RedisCache通过操作redis缓存数据
 *               3)、默认保存数据 k-v 都是object ,利用序列化保存；如何保存为json
 *                       1、引入了redis的starter,CacheManager 变为 RedisCacheManager
 *                       2、默认创建的RedisCacheManager在操作redis的时候使用的是 RedisConnectionFactory.
 *                       3、在使用RedisTemplate<Object, Object>时 会根据 RedisConnectionFactory设置工厂。并且 RedisTemplate<Object, Object>
 *                           默认使用的是jdk的序列化机制。
 *               4)、自定义CacheManager
 *
 */
@MapperScan("org.learn.boot.cache.mapper")
@SpringBootApplication
@EnableCaching
public class LearnSpringBootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootCacheApplication.class, args);
	}

}
