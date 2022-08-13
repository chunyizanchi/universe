package com.cyzc.springboot.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * <p>ApplicationEventPublisher  applicationEventPublisher.publishEvent
 *
 * @author Cyzc
 * @since [2022/06/28 22:51]
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisher {

    private final ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public String buyOrder(String orderId){

        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        applicationEventPublisher.publishEvent(new OrderProductEvent(this, orderId));
        stopWatch.stop();
        log.info("任务全部完成，总耗时：({})毫秒", stopWatch.getTotalTimeMillis());

        return "购买成功";

    }
}
