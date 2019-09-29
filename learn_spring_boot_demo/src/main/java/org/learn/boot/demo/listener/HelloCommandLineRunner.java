package org.learn.boot.demo.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName: HelloCommandLineRunner
 * @Description:
 * @Author: lin
 * @Date: 2019/9/6 21:55
 * History:
 * @<version> 1.0
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...run..."+ Arrays.asList(args));
    }
}
