package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.service.ProducerService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> mq消息发送demo 每一个消息创建一个消费topic
 *
 * @author Cyzc
 * @since [2022/08/30 23:07]
 */

@RestController
@RequestMapping("/message")
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    @Resource
    private ProducerService producerService;

    @RequestMapping("/syncSend/{id}")
    public void syncSend(@PathVariable Integer id) {
        SendResult sendResult = producerService.syncSend(id);
        logger.info("send result {}", sendResult);
    }

    @RequestMapping("/sendOrderlyMessage")
    public void sendOrderlyMessage() {
        List<SendResult> sendResult = producerService.sendOrderlyMessage();
        logger.info("send result {}", sendResult);
    }

    //onewaySend
    @RequestMapping("/onewaySend/{id}")
    public void onewaySend(@PathVariable Integer id) {
        producerService.onewaySend(id);
    }

    //asyncSend
    @RequestMapping("/asyncSend")
    public void asyncSend() {

        for (int index = 0; index < 100; index++) {

            int finalIndex = index;
            producerService.asyncSend(finalIndex, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    logger.info("send success result{}", sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", finalIndex, e);
                    e.printStackTrace();
                }
            });
        }

    }
    //asyncSend
    @RequestMapping("/delaySend")
    public void delaySend() {

        for (int index = 0; index < 100; index++) {

            int finalIndex = index;
            producerService.asyncSend(finalIndex, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    logger.info("send success result{}", sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", finalIndex, e);
                    e.printStackTrace();
                }
            });
        }

    }
}
