package com.cyzc.why.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/01 14:38]
 */
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "consumer01-group")
@Component
public class ConsumerListener  implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息：" + message) ;
    }
}
