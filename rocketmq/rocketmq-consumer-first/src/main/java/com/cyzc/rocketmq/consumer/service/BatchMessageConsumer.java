package com.cyzc.rocketmq.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyzc.rocketmq.consumer.conf.TopicConstant;
import com.cyzc.rocketmq.consumer.message.Prize;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
 * @since [2022/12/08 20:33]
 */
@Component
@RocketMQMessageListener(topic = TopicConstant.BATCH_MESSAGE,
        consumerGroup = "consumer01-" + TopicConstant.BATCH_MESSAGE)
public class BatchMessageConsumer implements RocketMQListener<MessageExt> {

    private final Logger logger = LoggerFactory.getLogger(BatchMessageConsumer.class);

    @Override
    public void onMessage(MessageExt message) {

        String topic = message.getTopic();
        String tags = message.getTags();
        String body = new String(message.getBody(), StandardCharsets.UTF_8);

        logger.info("BatchMessageConsumer 接收消息，topic: {}, tags: {}, 消息内容：{}", topic, tags,
                body);
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);

        Prize prize = JSONObject.parseObject(message.getBody(), Prize.class);
        System.out.println(prize.toString());


    }
}
