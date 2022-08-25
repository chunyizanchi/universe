package com.cyzc.springboot.event;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * <p> 这是一个监听容器关闭的 监听者，当容器关闭的时候就会触发，
 *
 * @author Cyzc
 * @since [2022/08/25 23:20]
 */
@Component
public class ContextClosedHandler implements ApplicationListener<ContextClosedEvent> {

    Logger logger = LoggerFactory.getLogger(ContextClosedHandler.class);

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        threadPoolTaskExecutor.destroy();
        logger.info("ContextClosedHandler.onApplicationEvent");
    }
}
