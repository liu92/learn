package org.learn.jdk.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java8中有一种新的数据处理方式，那就是流Stream，
 * 结合lambda表达式能够更加简洁高效的处理数据。
 * Stream使用一种类似于SQL语句从数据库查询数据的直观方式，对数据进行如筛选、排序以及聚合等多种操作。
 *
 * @ClassName: StreamDemo
 * @Description:
 * @Author: lin
 * @Date: 2019/8/4 10:52
 * History:
 * @<version> 1.0
 */
public class StreamDemo {
    /**
     * Stream是一个来自数据源的元素队列并支持聚合操作，更像是一个更高版本的Iterator,原始版本的Iterator，
     * 只能一个个遍历元素并完成相应操作。而使用Stream，只需要指定什么操作，如“过滤长度大于10的字符串”等操作，Stream会内部遍历并完成指定操作。
       Stream中的元素在管道中经过中间操作（intermediate operation）的处理后，最后由最终操作（terminal operation）得到最终的结果。
       数据源：是Stream的来源，可以是集合、数组、I/O channel等转换而成的Stream；
       基本操作：类似于SQL语句一样的操作，比如filter,map,reduce,find,match,sort等操作。

       注意这里的操作流程 ： 当我们操作一个流时，实际上会包含这样的执行过程：
       获取数据源-->转换成Stream-->执行操作，返回一个新的Stream-->再以新的Stream继续执行操作--->直至最后操作输出最终结果。
     */

    public static void main(String[] args) {
        //1.使用Collection中的方法和Arrays
        String[] strArr =  new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(strArr);
        Stream<String> stream = list.stream();
        System.out.println("list stream ...." + stream);
        Stream<String> stream1 = Arrays.stream(strArr);
        System.out.println("Arrays stream ...." + stream1);


        //2. 使用Stream中提供的静态方法
        Stream<String> stream2 = Stream.of(strArr);
        System.out.println("Stream2 of ...." + stream2);
        Stream<Double> stream3 = Stream.generate(Math::random);
        System.out.println("Stream3 generate ...." + stream3);
        Stream<Object> stream4 = Stream.empty();
        System.out.println("stream4 empty ...." + stream4);
        Stream.iterate(1, i -> i++);

        /**
         * Intermediate（中间操作）:中间操作是指对流中数据元素做出相应转换或操作后依然返回为一个流Stream，
         * 仍然可以供下一次流操作使用。常用的有：map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip。
           Termial（结束操作）：是指最终对Stream做出聚合操作，输出结果。
         */



    }

}
