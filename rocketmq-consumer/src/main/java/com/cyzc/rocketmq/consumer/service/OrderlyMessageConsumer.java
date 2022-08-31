package com.cyzc.rocketmq.consumer.service;

import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import com.cyzc.rocketmq.consumer.message.PrizeMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/31 07:44]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.TOPIC_ORDERLY_MESSAGE, consumerGroup =
        "demo1-consumer-group-"
                + TopicConstant.TOPIC_ORDERLY_MESSAGE)
public class OrderlyMessageConsumer implements RocketMQListener<PrizeMessage> {

    private final Logger logger = LoggerFactory.getLogger(PrizeConsumer.class);

    @Override
    public void onMessage(PrizeMessage prizeMessage) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                prizeMessage);
    }
}
