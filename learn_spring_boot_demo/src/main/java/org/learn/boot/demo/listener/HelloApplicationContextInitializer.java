package org.learn.boot.demo.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  测试相应的 监听 这里， 使用ApplicationContextInitializer 监听ConfigurableApplicationContext
 *  如何让其生效呢？ApplicationContextInitializer和
 *   SpringApplicationRunListener要让其进行配置到 META-INF/spring.factories文件中
 * @ClassName: HelloApplicationContextInitializer
 * @Description:
 * @Author: lin
 * @Date: 2019/9/6 16:58
 * History:
 * @<version> 1.0
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    /**
     * Initialize the given application context.
     *
     * @param applicationContext the application to configure
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("ApplicationContextInitializer...initializer..." + applicationContext);
    }
}
