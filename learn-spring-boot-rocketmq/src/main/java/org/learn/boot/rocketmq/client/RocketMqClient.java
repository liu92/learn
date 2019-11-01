package org.learn.boot.rocketmq.client;

import com.sun.corba.se.impl.naming.pcosnaming.NameServer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName: RocketMqClient
 * @Description:
 * @Author: lin
 * @Date: 2019/10/17 10:18
 * History:
 * @<version> 1.0
 */

@Component
public class RocketMqClient {
    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;


    private DefaultMQProducer producer;


    @PostConstruct
    public void defaultMQProducer() {

        //生产者的组名
        producer= new DefaultMQProducer(producerGroup);
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        try {
            producer.start();
            System.out.println("-------->:producer启动了");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public String send(String topic, String tags,String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        Message message = new Message(topic, tags, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
        StopWatch stop = new StopWatch();
        stop.start();
        SendResult result = producer.send(message);
        System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
        stop.stop();
        return "{\"MsgId\":\""+result.getMsgId()+"\"}";
    }



//    public void defaultMQProducer() {
//        //生产者的组名
//        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
//        //指定NameServer地址，多个地址以 ; 隔开
//        producer.setNamesrvAddr(namesrvAddr);
//
//        try {
//            /**
//             * Producer对象在使用之前必须要调用start初始化，初始化一次即可
//             * 注意：切记不可以在每次发送消息时，都调用start方法
//             */
//            producer.start();
//
//            //创建一个消息实例，包含 topic、tag 和 消息体
//            //如下：topic 为 "TopicTest"，tag 为 "push"
//            Message message = new Message("TopicTest", "push",
//                    "发送消息----lin-----".getBytes(RemotingHelper.DEFAULT_CHARSET));
//
//            StopWatch stop = new StopWatch();
//            stop.start();
//
//            for (int i = 0; i < 10000; i++) {
//                SendResult result = producer.send(message,new MessageQueueSelector() {
//
//                    @Override
//                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
//                        Integer id = (Integer) arg;
//                        int index = id % mqs.size();
//                        return mqs.get(index);
//                    }
//                },1);
//                System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
//            }
//            stop.stop();
//            System.out.println("----------------发送一万条消息耗时：" + stop.getTotalTimeMillis());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            producer.shutdown();
//        }
//    }













}
