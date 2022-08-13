package com.cyzc.why.eventbus;


import com.google.common.cache.Cache;
import com.google.common.eventbus.EventBus;

/**
 * <p>Guava EventBus</p>
 *
 * @author Cyzc
 * @since [2021/12/23 13:43]
 */
public class EventBusCenter {
    private static EventBus eventBus=new EventBus();

    public EventBusCenter() {
    }
    /**
     * 获取eventBUS 实例
     * @return {@link EventBus}
     * @since 2021/12/23 13:45
     * @see
     */
    public static EventBus getInstance() {
        return eventBus;
    }
    /**
     * 注册事件
     * @param obj
     * @return {@link Void}
     * @since 2021/12/23 13:46
     */
    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }

}


