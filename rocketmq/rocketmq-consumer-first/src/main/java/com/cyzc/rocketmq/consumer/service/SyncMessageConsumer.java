package com.cyzc.rocketmq.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import com.cyzc.rocketmq.consumer.message.Prize;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ExtRocketMQConsumerConfiguration;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/12/08 14:20]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.SYNC_MESSAGE,
        consumerGroup = "consumer01-" + TopicConstant.SYNC_MESSAGE)
public class SyncMessageConsumer implements RocketMQListener<MessageExt> {

    private final Logger logger = LoggerFactory.getLogger(SyncMessageConsumer.class);


    @Override
    public void onMessage(MessageExt message) {

        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);


    }
}
