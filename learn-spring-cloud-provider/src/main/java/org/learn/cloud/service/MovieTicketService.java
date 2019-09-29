package org.learn.cloud.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: MovieTicketService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 20:47
 * History:
 * @<version> 1.0
 */
@Service
public class MovieTicketService {

    public String getTicket(){
        return "《流浪地球》";
    }
}
