package com.cyzc.designpattern.observerPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/20 00:00]
 */
public class ConcreteObserverTwo implements Observer{

    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified. messageId="+message.getMessageId());
    }
}
