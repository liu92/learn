package org.learn.jdk.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream 操作分为两类
 * 1、 Intermediate（中间操作）:中间操作是指对流中数据元素做出相应转换或操作后依然返回为一个流Stream，
 * 仍然可以供下一次流操作使用。常用的有：map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip。
 * 2、Termial（结束操作）：是指最终对Stream做出聚合操作，输出结果。
 * @ClassName: StreamD
 * @Description:
 * @Author: lin
 * @Date: 2019/8/4 11:10
 * History:
 * @<version> 1.0
 */
public class StreamD {
    public static void main(String[] args) {
        /**
         * 下面这么一个简单的小需求：求一个集合中字串长度小于5的数量。  如果是用于原来的判断，需要写很多冗长的代码 可读性也不高
         * 如果使用 stream 就可以像下面一样。
         */
        List<String> stringList = Arrays.asList("aa34", "bbsft" ,"ccytu", "wyr");
        /**
         * 这里使用了并行 parallelStream
         */
        long count = stringList.parallelStream().filter(t->t.length()<5).count();
        System.out.println("字符串长度小于5的有=============="+count);
        /**
         * 使用 顺序 stream ,获取第一个元素 。
         */
        stringList.stream().findFirst().ifPresent(System.out::println);
        //同样可以使用stream 提供的方法
        //直接使用Stream.of()方法就能从一组对象创建一个stream对象，
        Stream.of("aaa", "bbb" ,"ccc").findFirst().ifPresent(System.out::println);

        /**
         * map方法是一对一的关系，将stream中的每一个元素按照映射规则成另外一个元素，而如果是一对多的关系的话就需要使用flatmap方法。
         * 遍历原stream中的元素，转换后构成新的stream：
         */
        List<String> result = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("result =============="+result);

        /**
         * JAVA 8中的IntStream,LongStream,DoubleStream这些流能够处理基本数据类型如：
         * int,long,double。比如：IntStream可以使用range()方法能够替换掉传统的for循环
         */
        IntStream.range(10, 13).forEach(System.out::println);

        /**
         * concat方法将两个Stream连接在一起，合成一个Stream。若两个输入的Stream都时排序的，
         * 则新Stream也是排序的；若输入的Stream中任何一个是并行的，则新的Stream也是并行的；若关闭新的Stream时，原两个输入的Stream都将执行关闭处理。
         */
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).forEach(System.out::println);

        /**
         * distinct：对流进行去重操作
         */
         Stream<String> stream = Stream.of("a" , "b" , "a" ,"b", "c");
          stream.distinct().forEach(e->System.out.println("distinct========"+e));

        /**
         * limit 限制流中元素的个数 ,
         * 如下实例 输出结果是a,b 取其前两个数据
         */
        Stream<String> stream1 = Stream.of("a" , "b" , "a" ,"b", "c");
        stream1.limit(2).forEach(e->System.out.println("limit============="+e));

        /**
         * skip 跳过流中前几个元素
         */
        Stream<String> streamSkip = Stream.of("a", "a", "b", "c");
        streamSkip.skip(2).forEach(e-> System.out.println("skip======="+e));
        /**
         * peek：对流中每一个元素依次进行操作，类似于forEach操作
         */
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        /**
         * sorted：对流中元素进行排序，可以通过sorted(Comparator<? super T> comparator)自定义比较规则
         */
        Stream<Integer> sortStream = Stream.of(3, 2, 1);
        sortStream.sorted(Integer::compareTo).forEach(so->System.out.println("sort============="+so));

        /**
         * max/min：找出流中最大或者最小的元素
         */
        Stream<Integer> maxStream = Stream.of(3, 2, 1);
        System.out.println("maxStream================="+maxStream.max(Integer::compareTo).get());
    }
}
