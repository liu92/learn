package org.learn.jdk.functinter;

/**
 * @ClassName: Java8Test
 * @Description: 测试
 * @Author: lin
 * @Date: 2019/8/3 21:55
 * History:
 * @<version> 1.0
 */
public class Java8Test {
    public static void main(String[] args) {
        Java8Test test = new Java8Test();

        // 类型声明
        MathOperation addition = (int a, int b) ->a+b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a-b;

        // 大括号中的返回语句

        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 =" +  test.operate(10, 5, addition));
        System.out.println("10 - 5 = " + test.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + test.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + test.operate(10, 5, division));


    }

    interface  MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void  sayMessage(String message);
    }

    private  int operate(int a, int b, MathOperation mathOperation){
        return  mathOperation.operation(a, b);
    }
}


