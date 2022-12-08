package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.conf.TopicConstant;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/12/08 16:27]
 */
@RestController
@RequestMapping("/message")
public class TransactionMessageController {


    private final Logger logger = LoggerFactory.getLogger(TransactionMessageController.class);

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/transaction/{number}")
    public TransactionSendResult sendTransactionMessage(@PathVariable Integer number) {
        logger.info("接收到事务请求，准备执行生产者本地事务。..");
        Message<String> message = MessageBuilder.withPayload("通知消费者执行本地事务的事务消息")
                .build();

        TransactionSendResult transactionSendResult = this.rocketMQTemplate.sendMessageInTransaction(
                TopicConstant.TRANSACTION_MESSAGE, message, number);
        logger.info("生产者发送状态：{}", transactionSendResult.getSendStatus().toString());
        logger.info("本地事务执行结果：{}",
                transactionSendResult.getLocalTransactionState().toString());

        return transactionSendResult;
    }
}
