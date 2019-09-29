package org.learn.boot.demo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 测试监听 ，这两个runner要让其放到容器中就行了 ，
 *  ApplicationRunner和CommandLineRunner 放在容器中就可以，因为在源码中也是从容器中获取这两个
 * @ClassName: HelloApplicationRunner
 * @Description:
 * @Author: lin
 * @Date: 2019/9/6 21:55
 * History:
 * @<version> 1.0
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run...");
    }
}
