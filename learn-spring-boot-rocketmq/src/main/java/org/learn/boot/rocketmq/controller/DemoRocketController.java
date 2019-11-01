package org.learn.boot.rocketmq.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.learn.boot.rocketmq.client.RocketMqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 测试发送消息
 * @ClassName: DemoRocketController
 * @Description:
 * @Author: lin
 * @Date: 2019/10/19 9:49
 * History:
 * @<version> 1.0
 */
@RestController
public class DemoRocketController {
    @Autowired
    private RocketMqClient rocketMqClient;

    @RequestMapping("/push/{msg}")
    public String testMq(@PathVariable("msg") String msg) {
        try {
            rocketMqClient.send("PushTopic","push",msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  "ERROR";
    }
}
