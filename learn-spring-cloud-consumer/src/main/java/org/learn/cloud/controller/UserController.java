package org.learn.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 21:17
 * History:
 * @<version> 1.0
 */

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name){
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/getTicket", String.class);
        return name + "购买了" + s +"票";
    }
}
