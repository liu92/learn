package org.learn.boot.task.quartz.job;

import org.quartz.*;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: HelloJob
 * @Description: 测试Quartz
 * @Author: lin
 * @Date: 2020/8/10 16:44
 * History:
 * @<version> 1.0
 */
public class HelloJob  implements Job {

   public HelloJob(){
       System.out.println("欢迎访问HelloJob");
   }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        //输出当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);

        JobKey jobKey = context.getJobDetail().getKey();
        System.out.println("工作任务名称：" + jobKey.getName() + " ;工作任务的组"+ jobKey.getGroup());
        System.out.println("任务类的名称（带路径）：" + context.getJobDetail().getJobClass().getName());
        System.out.println("任务类的名称："+ context.getJobDetail().getJobClass().getSimpleName());

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String message = jobDataMap.getString("message");
        System.out.println("任务数据的参数值：" + message);

        JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
        String triggerDataMapString = triggerDataMap.getString("message");
        System.out.println("触发器数据的参数值：" + triggerDataMapString);

        System.out.println("测试，测试时间是："+ dateString);





    }
}
