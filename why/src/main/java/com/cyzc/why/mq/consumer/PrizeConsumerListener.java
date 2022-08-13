package com.cyzc.why.mq.consumer;

import com.cyzc.why.entity.Prize;
import com.cyzc.why.mq.TopicEnum;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/02 11:23]
 */
@RocketMQMessageListener(topic = "PRIZE", consumerGroup = "prizeMessage-group")
@Component
public class PrizeConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息：" + message) ;

    }
}
