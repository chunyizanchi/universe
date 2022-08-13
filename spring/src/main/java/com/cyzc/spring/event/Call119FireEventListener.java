package com.cyzc.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * <p> 监听事件
 *
 * @author Cyzc
 * @since [2022/08/10 15:17]
 */
public class Call119FireEventListener implements ApplicationListener<FireEvent> {

    @Override
    public void onApplicationEvent(FireEvent event) {
        System.out.println("拨打119");
    }
}
