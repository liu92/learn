package org.learn.boot.rocketmq.server;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RocketMqServer
 * @Description:
 * @Author: lin
 * @Date: 2019/10/17 10:18
 * History:
 * @<version> 1.0
 */
@Component
public class RocketMqServer implements CommandLineRunner {
    /**
     * 消费者的组名
     */
    @Value("${apache.rocketmq.consumer.pushConsumer}")
    private String consumerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;




    /**
     * 初始化RocketMq的监听信息，渠道信息
     */
    public void messageListener(){

        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("SpringBootRocketMqGroup");

        consumer.setNamesrvAddr(namesrvAddr);
        try {

            // 订阅PushTopic下Tag为push的消息,都订阅消息
            consumer.subscribe("PushTopic", "push");

            // 程序第一次启动从消息队列头获取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            //可以修改每次消费消息的数量，默认设置是每次消费一条
            consumer.setConsumeMessageBatchMaxSize(1);

            //在此监听中消费信息，并返回消费的状态信息
            consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {

                // 会把不同的消息分别放置到不同的队列中
                for(Message msg:msgs){

                    System.out.println("接收到了消息："+new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

            consumer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        this.messageListener();
    }


//public void defaultMQPushConsumer() {
//        //消费者的组名
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//
//        //指定NameServer地址，多个地址以 ; 隔开
//        consumer.setNamesrvAddr(namesrvAddr);
//        try {
//            //订阅PushTopic下Tag为push的消息
//            consumer.subscribe("TopicTest", "push");
//
//            //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
//            //如果非第一次启动，那么按照上次消费的位置继续消费
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//            consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
//                try {
//                    for (MessageExt messageExt : list) {
//                        //输出消息内容
//                        System.out.println("messageExt: " + messageExt);
//
//                        String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
//                        //输出消息内容
//                        System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + messageBody);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    //稍后再试
//                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//                }
//                //消费成功
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            });
//            consumer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }









}
