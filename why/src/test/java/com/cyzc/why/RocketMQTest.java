package com.cyzc.why;

import com.cyzc.why.entity.Prize;
import com.cyzc.why.mq.RocketMqHelper;
import com.cyzc.why.mq.TopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/02 11:24]
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class RocketMQTest {

    @Autowired
    private RocketMqHelper rocketMqHelper;


    @Test
    public void testProducer() {
        Prize person = new Prize();
        person.setId(1);
        person.setPrizeName("1");
        person.setCount(1);
        person.setPossibility(1);
        person.setActId(1);
        String name = TopicEnum.PRIZE.name();
        System.out.println(name);
        rocketMqHelper.asyncSend(TopicEnum.PRIZE,
                MessageBuilder.withPayload(person).build());

    }

}
