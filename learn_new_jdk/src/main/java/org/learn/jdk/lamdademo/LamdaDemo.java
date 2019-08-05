package org.learn.jdk.lamdademo;

import java.util.function.Function;

/**
 * @ClassName: LamdaDemo
 * @Description:
 * @Author: lin
 * @Date: 2019/8/3 22:42
 * History:
 * @<version> 1.0
 */
public class LamdaDemo {
    public static void main(String[] args) {
        String hello = "hello lambda ";
        Function<String, Void> func = (name)->{
            System.out.println(hello + name);
            return  null;
        };
        func.apply("ce");
    }
}
