package org.learn.jdk.staticmethod;

/**
 * 测试 jdk 8 接口的静态方法和默认方法,
 * 如果 实现类实现多个 接口，在多个结果中又有相同的方法，那么就会造成冲突。
 * @ClassName: DefaultMethodTest
 * @Description:
 * @Author: lin
 * @Date: 2019/8/3 21:23
 * History:
 * @<version> 1.0
 */
public class DefaultMethodTest implements IDonkey ,IHorse{

    public static void main(String[] args) {
        DefaultMethodTest defaultMethodTest = new DefaultMethodTest();
        defaultMethodTest.run();
    }

    /**
     * 针对由默认方法引起的方法冲突问题，只有通过重写冲突方法，并方法绑定的方式，指定以哪个接口中的默认方法为准。
     */
    @Override
    public void run() {
       IHorse.super.run();
    }
}
