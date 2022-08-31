package com.cyzc.rocketmq.producer.service;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import com.cyzc.rocketmq.producer.message.PrizeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 22:45]
 */
@Component
public class ProducerService {

    AtomicInteger atomicInteger = new AtomicInteger(100);
    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id) {
        // 创建 Demo01Message 消息
        PrizeMessage message = new PrizeMessage();
        message.setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(PrizeMessage.TOPIC, message);
    }

    public void asyncSend(Integer id, SendCallback callback) {
        // 创建 Demo01Message 消息
        PrizeMessage message = new PrizeMessage();
        message.setId(id);
        // 异步发送消息
        rocketMQTemplate.asyncSend(PrizeMessage.TOPIC, message, callback);
    }

    public void onewaySend(Integer id) {
        // 创建 Demo01Message 消息
        PrizeMessage message = new PrizeMessage();
        message.setId(id);
        // oneway 发送消息
        rocketMQTemplate.sendOneWay(PrizeMessage.TOPIC, message);
    }

    public List<SendResult> sendOrderlyMessage() {
        List<SendResult> sendResultList=new ArrayList<>();
        List<PrizeMessage> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            PrizeMessage message = new PrizeMessage();
            message.setId(atomicInteger.getAndIncrement());
            list.add(message);
        }

        for (PrizeMessage p : list) {
            SendResult sendResult = rocketMQTemplate.syncSendOrderly(TopicConstant.TOPIC_HELLOROCKETMQ,
                    MessageBuilder.withPayload(list.toString()), String.valueOf(p.getId()));
            logger.info("send result {}", sendResult);
            sendResultList.add(sendResult);
        }
        return sendResultList;



    }
}
