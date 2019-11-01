package org.lear.boot.kafka.sender;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.lear.boot.kafka.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: KafkaSender
 * @Description:
 * @Author: lin
 * @Date: 2019/10/23 15:19
 * History:
 * @<version> 1.0
 */
@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    /**
     * 发送消息方法
     */
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("测试kafka消息发送 +++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("lin", gson.toJson(message));
    }
}
