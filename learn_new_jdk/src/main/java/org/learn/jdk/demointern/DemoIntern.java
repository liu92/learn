package org.learn.jdk.demointern;

/**
 * @ClassName: DemoIntern
 * @Description:
 * @Author: lin
 * @Date: 2019/10/16 12:05
 * History:
 * @<version> 1.0
 */
public class DemoIntern {
    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        //计算机
        System.out.println(s2);
        //false，因为一个是堆内存中的String对象一个是常量池中的String对象，
        System.out.println(s1 == s2);
        //true，因为两个都是常量池中的String对象
        System.out.println(s3 == s2);
    }
}
