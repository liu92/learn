package org.learn.boot.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 21:41
 * History:
 * @<version> 1.0
 */
@Controller
public class HelloController {

    @GetMapping("/te")
    public String hello(){
        return "hello";
    }
}
