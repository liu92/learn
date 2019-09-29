package org.learn.boot.dubbo.ticket.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TicketServiceImpl
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 14:11
 * History:
 * @<version> 1.0
 */
@Component
@Service
public class TicketServiceImpl implements TicketService {
    /**
     * 获取票
     *
     * @return
     */
    @Override
    public String getTicket() {
        return "《哪吒》";
    }
}
