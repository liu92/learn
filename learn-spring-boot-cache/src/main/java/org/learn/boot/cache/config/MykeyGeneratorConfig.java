package org.learn.boot.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义 keyGenerator
 * @ClassName: MykeyGeneratorConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 8:11
 * History:
 * @<version> 1.0
 */
@Configuration
public class MykeyGeneratorConfig {

    @Bean("mykeyGenerator")
    public KeyGenerator keyGenerator(){
        return (target, method, params) -> method.getName() + "["+ Arrays.asList(params).toString() +"]";
    }
}
