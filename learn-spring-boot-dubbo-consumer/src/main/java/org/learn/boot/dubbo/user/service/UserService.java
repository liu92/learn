package org.learn.boot.dubbo.user.service;

import org.apache.dubbo.config.annotation.Reference;
import org.learn.boot.dubbo.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 14:52
 * History:
 * @<version> 1.0
 */
@Service
public class UserService {

    /**
     * 引用ticketService
     */
    @Reference
    TicketService ticketService;

    public void  hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了 "+ticket);
    }
}
