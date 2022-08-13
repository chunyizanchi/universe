package com.cyzc.springboot.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/28 22:48]
 */
@Component
@Slf4j
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();

        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Thread.sleep(2000);
        stopWatch.stop();
        log.info("校验订单id {} 商品价格耗时：({})毫秒", orderId, stopWatch.getTotalTimeMillis());
    }
}
