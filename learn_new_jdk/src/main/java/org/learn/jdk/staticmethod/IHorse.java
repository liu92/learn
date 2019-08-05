package org.learn.jdk.staticmethod;

/**
 * @ClassName: IHorse
 * @Description: 在接口类中定义相同的默认方法 那么在实现这些接口时 就有相同的方法 从而造成冲突
 * @Author: lin
 * @Date: 2019/8/3 21:29
 * @History:
 * @<version> 1.0
 */
public interface IHorse {
    default void  run(){
        System.out.println("Horse run");
    }
}
