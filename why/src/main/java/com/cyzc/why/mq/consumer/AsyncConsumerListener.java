package com.cyzc.why.mq.consumer;

import com.cyzc.why.entity.Prize;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/01 15:29]
 */
@RocketMQMessageListener(topic = "AsyncMessage", consumerGroup = "AsyncConsumer-group")
@Component
public class AsyncConsumerListener  implements RocketMQListener<Prize> {

    @Override
    public void onMessage(Prize message) {
        System.out.println("接收到消息：" + message) ;

    }
}
