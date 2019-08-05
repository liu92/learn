package org.learn.jdk.optional;

import java.util.Optional;

/**
 * @ClassName: OptionalDemo
 * @Description:
 * @Author: lin
 * @Date: 2019/8/4 18:31
 * History:
 * @<version> 1.0
 */
public class OptionalDemo {

    /**
     * 为了解决空指针异常，在Java8之前需要使用if-else这样的语句去防止空指针异常，
     * 而在Java8就可以使用Optional来解决。Optional可以理解成一个数据容器，甚至可以封装null，
     * 并且如果值存在调用isPresent()方法会返回true。为了能够理解Optional。先来看一个例子：
     */

    private String getUserName(User user) {
        /**
         * 在java 8 前 需要对 传入的参数进行判断是否为null, 需要使用if else来进行判断
         * 而 java 8中 判断 参数是否为null 要比原来的精简很多.
         * Java8之前的if-else的逻辑判断，这是一种命令式编程的方式，
         * 而使用Optional更像是一种函数式编程，关注于最后的结果，而中间的处理过程交给JDK内部实现
         */
        Optional<User> userOptional = Optional.ofNullable(user);
        return userOptional.map(User::getUserName).orElse(null);
    }

    class User {
        private String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }

}
