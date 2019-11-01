package org.lear.boot.kafka.po;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: Message
 * @Description:
 * @Author: lin
 * @Date: 2019/10/23 12:58
 * History:
 * @<version> 1.0
 */
@Data
public class Message {
    private Long id;

    private String msg;

    private Date sendTime;
}
