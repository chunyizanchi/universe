package com.cyzc.rocketmq.consumer.service;

import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 23:07]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.EXTEND_MESSAGE,
        consumerGroup = "consumer02-" + TopicConstant.EXTEND_MESSAGE)
public class StringConsumer implements RocketMQListener<String> {

    private final Logger logger = LoggerFactory.getLogger(StringConsumer.class);

    @Override
    public void onMessage(String message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);
    }

}
