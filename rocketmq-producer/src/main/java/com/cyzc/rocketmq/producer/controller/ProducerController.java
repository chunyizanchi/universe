package com.cyzc.rocketmq.producer.controller;

import com.cyzc.rocketmq.producer.service.ProducerService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 23:07]
 */

@RestController
@RequestMapping("/msg")
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    @Resource
    private ProducerService producerService;

    @RequestMapping("{id}")
    public void sendMessage(@PathVariable Integer id) {
        SendResult sendResult = producerService.syncSend(id);
        logger.info("send result {}", sendResult);
    }

    @RequestMapping("/sendOrderlyMessage")
    public void sendOrderlyMessage() {
        List<SendResult> sendResult = producerService.sendOrderlyMessage();
    }
}
