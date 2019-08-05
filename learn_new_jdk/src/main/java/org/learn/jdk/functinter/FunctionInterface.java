package org.learn.jdk.functinter;

/**
 * @ClassName: FunctionInterface
 * @Description: Java8最大的变化是引入了函数式思想，也就是说函数可以作为另一个函数的参数。
 * 函数式接口，要求接口中有且仅有一个抽象方法，因此经常使用的Runnable，Callable接口就是典型的函数式接口。
 * 可以使用@FunctionalInterface注解，声明一个接口是函数式接口。如果一个接口满足函数式接口的定义，会默认转换成函数式接口。
 * 但是，最好是使用@FunctionalInterface注解显式声明。这是因为函数式接口比较脆弱，如果开发人员无意间新增了其他方法，
 * 就破坏了函数式接口的要求，如果使用注解@FunctionalInterface，开发人员就会知道当前接口是函数式接口，就不会无意间破坏该接口
 * @Author: lin
 * @Date: 2019/8/3 21:34
 * History:
 * @<version> 1.0
 */
@FunctionalInterface
public interface FunctionInterface {

    void handle();

    default void run(){
        System.out.println("run");
    }
}
