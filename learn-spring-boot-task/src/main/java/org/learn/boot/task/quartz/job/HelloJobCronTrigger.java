package org.learn.boot.task.quartz.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: HelloJobCronTrigger
 * @Description: 测试Quartz
 * @Author: lin
 * @Date: 2020/8/10 16:44
 * History:
 * @<version> 1.0
 */
public class HelloJobCronTrigger implements Job {

   public HelloJobCronTrigger(){
       System.out.println("欢迎访问HelloJob");
   }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        //输出当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);


        System.out.println("测试，测试时间是："+ dateString);





    }
}
