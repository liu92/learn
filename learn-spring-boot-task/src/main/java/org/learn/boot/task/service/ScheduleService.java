package org.learn.boot.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 任务调度 service
 * @ClassName: ScheduleService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 20:47
 * History:
 * @<version> 1.0
 */
@Service
public class ScheduleService {

    /**
     * second (秒) ，minute(分), hour(小时), day(天) , month(月),  day of week(周几).
     * {"0 * * * * MON-FRI"} means once per minute on weekdays
     * 这个注解 加了之后还要在启动类中开启 任务调度的注解 @EnableScheduling
     * 下面是每2s执行一次
     * 注意这个的星期 1-6 表示周一到周六，但是0和7表示都能代表周日， 这个与quartz 框架 不同 quartz 中 1-7中 1代表周日，2代表周一
     * 而这个spring的调度 框架 是0和7表示都能代表周日。 这点要特别注意
     *
     *  秒 分   时  日 月 周
     * [0 0/5 14,18 * * ? ] 每天14点整， 和18点整，每隔5分钟执行一次
     * [0 15 10 ? * 1-6] 每个月的周一到周五10:15分执行一次
     * [0 0 2 ? * 6L] 每个月的最后一个周六凌晨2点执行一次
     * [0 0 2 LW * ?] 每个月的最后一个工作日凌晨2点执行一次  ，LW 是最后一个工作日
     * [0 0 2-4 ? * 1#1] 每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
     *
     */
    @Scheduled(cron = "*/2 * * * * *")
    public void schedule(){
        System.out.println("任务调度测试");
    }
}
