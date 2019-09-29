package org.learn.boot.rabbitmq.po;

import lombok.Data;

/**
 * @ClassName: Bank
 * @Description:
 * @Author: lin
 * @Date: 2019/9/26 22:56
 * History:
 * @<version> 1.0
 */
@Data
public class Bank {

    private String number;

    private String name;

    public Bank(){

    }

    public Bank(String number, String name){
        this.number = number;
        this.name = name;
    }
}
