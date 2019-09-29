package org.learn.cloud.controller;

import org.learn.cloud.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MovieTicketController
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 20:48
 * History:
 * @<version> 1.0
 */
@RestController
public class MovieTicketController {

    @Autowired
    MovieTicketService movieTicketService;

    @GetMapping("/getTicket")
    public String  getTicket(){
        return  movieTicketService.getTicket();
    }
}
