package com.cyzc.rocketmq.poduer.test;

import com.cyzc.rocketmq.producer.RocketMQProducerApplication;
import javax.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 22:26]
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMQProducerApplication.class)
public class RocketMQProducerSendTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testSend(){
        rocketMQTemplate.convertAndSend("springboot-rocketmq","hello rocketmq");
    }
}
