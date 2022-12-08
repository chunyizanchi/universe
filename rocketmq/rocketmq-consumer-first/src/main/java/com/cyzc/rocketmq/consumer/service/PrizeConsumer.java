package com.cyzc.rocketmq.consumer.service;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import com.cyzc.rocketmq.consumer.message.Prize;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
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
 * @since [2022/08/30 22:48]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.TOPIC_PRIZE, consumerGroup = "consumer01-"
        + TopicConstant.TOPIC_PRIZE)
public class PrizeConsumer implements RocketMQListener<MessageExt> {

    private final Logger logger = LoggerFactory.getLogger(PrizeConsumer.class);

    @Override
    public void onMessage(MessageExt message) {
        String topic = message.getTopic();
        String tags = message.getTags();
        String body = new String(message.getBody(), StandardCharsets.UTF_8);

        logger.info("PrizeConsumer 接收消息，topic: {}, tags: {}, 消息内容：{}", topic, tags, body);
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);

        Prize prize = JSONObject.parseObject(message.getBody(), Prize.class);
        Integer id = prize.getId();
        String name = prize.getName();
        logger.info("PrizeConsumer 接收prize id: {}, name: {}", id, name);

        //come on 二进制字节流转换成java对象

    }
}
