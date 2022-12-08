package com.cyzc.rocketmq.consumer.service;

import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/12/08 11:52]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.ASYNC_MESSAGE,
        consumerGroup = "consumer02-" + TopicConstant.ASYNC_MESSAGE)
@Slf4j
public class AsyncMessageConsumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        String topic = message.getTopic();
        String tags = message.getTags();
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("SyncMessageConsumer 接收消息，topic: {}, tags: {}, 消息内容：{},message：{}", topic,
                tags, body, message);
    }
}
