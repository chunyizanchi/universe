package com.cyzc.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * <p> 创建火灾事件类，该类即我们需要处理的事件。需要继承ApplicationEvent
 *
 * @author Cyzc
 * @since [2022/08/10 15:16]
 */
public class FireEvent extends ApplicationEvent {


    public FireEvent(String source) {
        super(source);
    }
}
