package org.learn.boot.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步service
 * @ClassName: AsyncService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 20:35
 * History:
 * @<version> 1.0
 */
@Service
public class AsyncService {


    /**
     * 如果不在方法加入
     * @Async 注解那么这是一个同步方法，它会等待2s钟
     * 如果加入了说明这个方法就是异步的, 并且启动类中也要加入相应的注解 @EnableAsync 来开启注解
     */
    @Async
    public void hello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中......");
    }
}
