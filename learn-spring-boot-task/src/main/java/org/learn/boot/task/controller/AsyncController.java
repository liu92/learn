package org.learn.boot.task.controller;

import org.learn.boot.task.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: AsyncController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 20:39
 * History:
 * @<version> 1.0
 */
@RestController
public class AsyncController {

    @Resource
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return  "success";
    }
}
