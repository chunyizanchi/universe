package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DelayMessageController {

    private final Logger logger = LoggerFactory.getLogger(DelayMessageController.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @GetMapping("/delay")
    public SendResult sendDelayMessage() {
        Message<String> message = MessageBuilder.withPayload("send delay message").build();
        log.info("生产者发送消息：{}", message);
        SendResult sendResult = this.rocketMQTemplate.syncSend(TopicConstant.DELAY_MESSAGE, message,
                3000, 5);
        log.info("消息发送状态：{},当前时间 {}", sendResult, LocalDateTime.now());
        return sendResult;
    }

}
