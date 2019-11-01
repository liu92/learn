package org.lear.boot.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lear.boot.kafka.consumer.KafkaReceiver;
import org.lear.boot.kafka.sender.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoKafkaController
 * @Description:
 * @Author: lin
 * @Date: 2019/10/23 12:25
 * History:
 * @<version> 1.0
 */
@RestController
@RequestMapping("kafka")
public class DemoKafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private  KafkaSender kafkaSender;



    private void  send(String key, String data){
//        kafkaTemplate.send("my-replicated-topic", key, data);
        kafkaSender.send();
    }

    // test 主题 1 my_test 3

    @RequestMapping("/test")
    public String testKafka() {
        int iMax = 6;
        for (int i = 1; i < iMax; i++) {
            send("key"   + i, "data" + i);
        }
        return "success";
    }


//    /**
//     * 消费者使用日志打印消息
//     */
//    @KafkaListener(topics = "my-replicated-topic")
//    public void receive(ConsumerRecord<?, ?> consumer) {
//        System.out.println("topic名称:" + consumer.topic()
//                + ",key:" + consumer.key() + ",分区位置:" + consumer.partition()
//                + ", 下标" + consumer.offset());
//    }
}
