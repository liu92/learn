package org.learn.jdk.staticmethod;

/**
 * 实际上默认方法的改进，使得java类能够拥有类似多继承的能力，
 * 即一个对象实例，将拥有多个接口的实例方法，自然而然也会存在方法重复冲突的问题。
 *
 * @ClassName: IDonkey
 * @Description:
 * @Author: lin
 * @Date: 2019/8/3 21:25
 * @History:
 * @<version> 1.0
 */
public interface IDonkey {
    default void run(){
        System.out.println("IDonkey run");
    }


}
