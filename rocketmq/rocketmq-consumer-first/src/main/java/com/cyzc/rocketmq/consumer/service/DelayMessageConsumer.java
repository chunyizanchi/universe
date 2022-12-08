package com.cyzc.rocketmq.consumer.service;

import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/12/08 12:24]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.DELAY_MESSAGE,
        consumerGroup = "consumer01-" + TopicConstant.DELAY_MESSAGE)
public class DelayMessageConsumer implements RocketMQListener<MessageExt> {

    private final Logger logger = LoggerFactory.getLogger(PrizeConsumer.class);

    @Override
    public void onMessage(MessageExt message) {
        logger.info("接受延时消息，当前时间 {}", LocalDateTime.now());
        String topic = message.getTopic();
        String tags = message.getTags();
        String body = new String(message.getBody(), StandardCharsets.UTF_8);

        logger.info("DelayMessageConsumer 接收消息，topic: {}, tags: {}, 消息内容：{}", topic, tags,
                body);
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);
    }
}
