package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import com.cyzc.rocketmq.producer.message.Prize;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
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
public class SyncMessageController {

    private final Logger logger = LoggerFactory.getLogger(SyncMessageController.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/syncSend")
    public SendResult syncSend() {
        List<Message<Prize>> messageList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

            Prize prize = new Prize();
            prize.setName("Prize" + i);
            prize.setId(i);

            Message<Prize> message = MessageBuilder.withPayload(prize).build();
            messageList.add(message);
            logger.info("生产者发送消息：{}", message);
        }

        //Message<messages> message = MessageBuilder.withPayload(messages).build();
        log.info("生产者发送消息：{}", messageList);
        SendResult sendResult = this.rocketMQTemplate.syncSend(TopicConstant.SYNC_MESSAGE, messageList);
        log.info("消息发送状态：{}", sendResult);
        return sendResult;
    }

}
