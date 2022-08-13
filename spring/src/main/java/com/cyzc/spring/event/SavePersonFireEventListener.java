package com.cyzc.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 15:20]
 */
public class SavePersonFireEventListener implements ApplicationListener<FireEvent> {

    @Override
    public void onApplicationEvent(FireEvent event) {
        System.out.println("救人");
    }
}
