package com.cyzc.designpattern.observerPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/19 23:59]
 */
public class ConcreteObserverOne implements Observer {

    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified. messageId="+message.getMessageId());
    }
}
