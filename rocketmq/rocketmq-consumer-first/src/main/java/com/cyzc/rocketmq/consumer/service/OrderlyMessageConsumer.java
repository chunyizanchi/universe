package com.cyzc.rocketmq.consumer.service;

import com.cyzc.rocketmq.consumer.conf.TopicConstant;
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
 * @since [2022/08/31 07:44]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.ORDERLY_MESSAGE,
        consumerGroup = "consumer01-" + TopicConstant.ORDERLY_MESSAGE)
public class OrderlyMessageConsumer implements RocketMQListener<MessageExt> {

    private final Logger logger = LoggerFactory.getLogger(OrderlyMessageConsumer.class);

    @Override
    public void onMessage(MessageExt prizeMessage) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                prizeMessage);
    }
}
