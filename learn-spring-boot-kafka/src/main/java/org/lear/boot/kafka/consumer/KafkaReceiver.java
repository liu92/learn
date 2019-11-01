package org.lear.boot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName: KafkaReceiver
 * @Description:
 * @Author: lin
 * @Date: 2019/10/23 15:21
 * History:
 * @<version> 1.0
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"lin"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            log.info("测试kafka接收消息----------------- record =" + record);
            log.info("测试kafka接收消息------------------ message =" + message);
        }

    }
}
