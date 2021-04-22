package org.learn.boot.task.quartz.main;

import org.learn.boot.task.quartz.job.HelloJob;
import org.learn.boot.task.quartz.job.HelloJobCronTrigger;
import org.learn.boot.task.util.DateTool;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @ClassName: HelloSchedulerDemoCronTrigger
 * @Description:
 * @Author: lin
 * @Date: 2020/8/10 16:46
 * History:
 * @<version> 1.0
 */
public class HelloSchedulerDemoCronTrigger {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        /**
         * 1:调度器Scheduler，从工厂中获取调度的实例（默认：实例化new StdSchedulerFactory()）
         */
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Date startDate = DateTool.getCurrentDate();
        startDate.setTime(startDate.getTime() + 3000);

        Date endDate = DateTool.getCurrentDate();
        endDate.setTime(endDate.getTime() + 10000);

        /**
         * 2:实例任务（JobDetail）
         * 加载任务类，与HelloJob完成绑定，要求HelloJob实现job
         */

        JobDetail jobDetail = JobBuilder.newJob(HelloJobCronTrigger.class)
                /**
                 * 参数1：任务的名称（唯一实例）；参数2：任务组的名称
                 */
                .withIdentity("job1","group1")
                .usingJobData("message","打印日志")
                .build();

//        System.out.println("名称: "+jobDetail.getKey().getName());
//        //如果没有指定组名那么就是默认的：DEFAULT
//        System.out.println("组的名称: "+jobDetail.getKey().getGroup());
//        System.out.println("任务类: "+jobDetail.getJobClass().getName());

        /**
         * 3、触发器(Trigger)
         */
        Trigger  trigger = TriggerBuilder.newTrigger()
                /**
                 * 参数1：触发器的名称（唯一实例）；参数2：触发器组的名称
                 */
                 .withIdentity("trigger1","group1")
                 .startAt(startDate)
                 .endAt(endDate)
                 .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                //传递参数，名称为message
                .usingJobData("message","Simple触发去")
                .build();

        /**
         * 让调度器灌篮任务和触发器，保证按照触发器定义的条件执行任务
         */
         scheduler.scheduleJob(jobDetail, trigger);
         //启动
         scheduler.start();


         Thread.sleep(2000L);

         //挂起
         //scheduler.standby();

        /**
         * 关闭
         *
         */

        scheduler.shutdown();
    }

}
