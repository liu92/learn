package org.learn.boot.cache.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * MyBatisConfig 配置， 这个是一个配置类
 * @ClassName: MyBatisConfig
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 20:46
 * History:
 * @<version> 1.0
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    /**
     * @Bean 的作用是将下面的配置加入到容器中去
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return  new ConfigurationCustomizer(){

            /**
             * Customize the given a {@link Configuration} object.
             *
             * @param configuration the configuration object to customize
             */
            @Override
            public void customize(Configuration configuration) {
                //这个是去开启驼峰命名法
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
