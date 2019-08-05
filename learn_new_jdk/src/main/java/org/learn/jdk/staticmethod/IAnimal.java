package org.learn.jdk.staticmethod;

/**
 * @ClassName: IAnimal
 * @Description: jdk8 接口的默认方法和静态方法
 * @Author: lin
 * @Date: 2019/8/3 21:21
 * @History:
 * @<version> 1.0
 */
public interface IAnimal {
    /**
     * 默认方法
     */
    default void breath(){
        System.out.println("breath");
    }

    /**
     * 在jdk 8 中方法可以声明为静态方法
     */

    static void run(){
    }
}
