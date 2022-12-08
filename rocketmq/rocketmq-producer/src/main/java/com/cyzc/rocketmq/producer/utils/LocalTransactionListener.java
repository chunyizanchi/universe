package com.cyzc.rocketmq.producer.utils;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * <p>事务消息需要实现一个本地事务监听器
 *
 * @author Cyzc
 * @since [2022/12/08 16:26]
 */
@Slf4j
@RocketMQTransactionListener
public class LocalTransactionListener implements RocketMQLocalTransactionListener {


    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info("接收到 RocketMQ 的 Half 消息的响应，现在执行本地事务。..");
        int number = (Integer) arg;
        try {
            // 使用除法方便演示事务异常
            Integer result = 100 / number;
            log.info("事务执行结果：{}", result);
            // 线程睡眠 500 毫秒模拟本地事务执行
            TimeUnit.MILLISECONDS.sleep(500);
            log.info("本地事务执行成功，给 RocketMQ 发送 ACK 响应");
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.info("本地事务执行发生异常，需要回滚事务");
            return RocketMQLocalTransactionState.ROLLBACK;
        }

    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        log.info(
                "由于 RocketMQ 长时间无法收到消息的状态或本地执行事务状态为 UNKNOW，现在执行补偿事务/回查本地事务。..");
        return RocketMQLocalTransactionState.COMMIT;
    }
}
