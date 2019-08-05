package org.learn.jdk.dateapi;

import java.time.*;

/**
 * @ClassName: TimeTest
 * @Description:
 * @Author: lin
 * @Date: 2019/8/4 18:38
 * History:
 * @<version> 1.0
 */
public class TimeTest {
    /**
     * 在Java8之前的版本中，日期时间API存在很多的问题，
     * 线程安全问题：java.util.Date是非线程安全的，所有的日期类都是可变的；
     设计很差：在java.util和java.sql的包中都有日期类，此外，用于格式化和解析的类在java.text包中也有定义。而每个包将其合并在一起，也是不合理的；
     时区处理麻烦：日期类不提供国际化，没有时区支持，因此Java中引入了java.util.Calendar和Java.util.TimeZone类；
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
         * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()
           Instant:一个instant对象表示时间轴上的一个时间点，Instant.now()方法会返回当前的瞬时点（格林威治时间）；
           Duration:用于表示两个瞬时点相差的时间量；
           LocalDate:一个带有年份，月份和天数的日期，可以使用静态方法now或者of方法进行创建；
           LocalTime:表示一天中的某个时间，同样可以使用now和of进行创建；
           LocalDateTime：兼有日期和时间；
           ZonedDateTime：通过设置时间的id来创建一个带时区的时间；
           DateTimeFormatter：日期格式化类，提供了多种预定义的标准格式；
         */
        Clock clock = Clock.systemUTC();
        Instant instant = clock.instant();
        System.out.println(instant.toString());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime.toString());

    }
}
