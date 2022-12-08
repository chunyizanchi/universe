package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/12/08 12:10]
 */
@RestController
@RequestMapping("/message")
public class AsyncMessageController {

    private final Logger logger = LoggerFactory.getLogger(AsyncMessageController.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @GetMapping("/asyncSend")
    public String asyncSend() {
        Message<String> message = MessageBuilder
                .withPayload("send ordinary message asynchronously")
                .setHeader("KEYS", UUID.randomUUID().toString()) //set keys
                .build();
        this.rocketMQTemplate.asyncSend(TopicConstant.ASYNC_MESSAGE, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                logger.info("消息发送状态：{}", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                logger.info("消息发送失败，原因：", e);
            }
        });
        logger.info("生产者发送消息：{}", message);
        return "sent message";
    }

}
