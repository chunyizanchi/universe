package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import com.cyzc.rocketmq.producer.message.Prize;
import com.cyzc.rocketmq.producer.utils.MessagesSplitter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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
public class BatchMessageController {

    private final Logger logger = LoggerFactory.getLogger(BatchMessageController.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/batch")
    public String sendMessageInBatch() {
        List<Message<String>> messages = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String messageBody = "批量发送消息第" + i + "条";
            Message<String> message = MessageBuilder.withPayload(messageBody).build();
            messages.add(message);
            logger.info("生产者发送消息：{}", message);
        }

        // 可能这个消息集合超出限制，需要将其分裂成若干个满足要求的小消息
        MessagesSplitter messagesSplitter = new MessagesSplitter(messages);
        while (messagesSplitter.hasNext()) {
            List<Message<String>> subMessageList = messagesSplitter.next();
            SendResult sendResult = this.rocketMQTemplate.syncSend(TopicConstant.BATCH_MESSAGE,
                    subMessageList);
            logger.info("消息发送状态：{}", sendResult);

        }
        return "sent message";
    }

    @GetMapping("/batchSendPrize")
    public String batchSendPrize() {
        List<Message<Prize>> messages = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String messageBody = "批量发送消息第" + i + "条";
            Prize prize = new Prize();
            prize.setName("Prize" + i);
            prize.setId(i);

            Message<Prize> message = MessageBuilder.withPayload(prize).build();
            messages.add(message);
            logger.info("生产者发送消息：{}", message);
        }

        SendResult sendResult = this.rocketMQTemplate.syncSend(TopicConstant.BATCH_MESSAGE,
                messages);
        logger.info("消息发送状态：{}", sendResult);

        return "sent message";
    }
}
