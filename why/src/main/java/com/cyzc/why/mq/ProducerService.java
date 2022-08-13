package com.cyzc.why.mq;

import com.cyzc.why.entity.Prize;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/01 14:37]
 */
@Service
@Slf4j
public class ProducerService {
    @Resource
    private RocketMQTemplate rocketMQTemplate ;

    public void send(String message) {
        log.info("send");
        rocketMQTemplate.convertAndSend("test-topic", message);
    }

    public void sendAsyncMessage(Integer messageCount) throws InterruptedException {


        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            try {


                final int index = i;
                Prize prize=new Prize();
                prize.setId(i);
                prize.setPrizeName(String.valueOf(i));
                prize.setCount(i);
                prize.setPossibility(i);
                prize.setActId(i);
                /*Message msg = new Message("AsyncMessage",
                        "TagA",
                        "OrderID188",
                        "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));*/
                Message msg = new Message("AsyncMessage",
                        "TagA",
                        "OrderID188",
                        prize.toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
                rocketMQTemplate.asyncSend("AsyncMessage",msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, e);
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        countDownLatch.await(5, TimeUnit.SECONDS);

        log.info("sendsuccess");

    }
}
