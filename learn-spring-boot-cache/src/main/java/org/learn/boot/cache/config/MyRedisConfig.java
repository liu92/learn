package org.learn.boot.cache.config;

import org.learn.boot.cache.po.Department;
import org.learn.boot.cache.po.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * redis 自定义序列化器
 * @ClassName: MyRedisConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 11:03
 * History:
 * @<version> 1.0
 */
@Configuration
public class MyRedisConfig {


    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }


    @Bean
    public RedisCacheManager departCacheManager(RedisConnectionFactory redisConnectionFactory,
                                                  ResourceLoader resourceLoader){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        // redisCacheConfiguration.entryTtl(Duration.ofDays(1)); 设置缓存的默认过期时间，也是使用Duration设置
        //  redisCacheConfiguration.disableCachingNullValues();不缓存空值
        redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair
                .fromSerializer(new Jackson2JsonRedisSerializer<>(Department.class)));
        // 设置一个初始化的缓存空间set集合
        Set<String> cacheNames =  new HashSet<>();
        cacheNames.add("my-redis-cache1");
        cacheNames.add("my-redis-cache2");

        RedisCacheManager builder = RedisCacheManager
                .builder(redisConnectionFactory)
//                .initialCacheNames(cacheNames)
                .cacheDefaults(redisCacheConfiguration).build();
        return builder;
    }




}
