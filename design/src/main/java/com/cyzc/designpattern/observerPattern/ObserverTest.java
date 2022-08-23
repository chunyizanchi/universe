package com.cyzc.designpattern.observerPattern;

/**
 * <p> 观察者模式，有事件，事件触发条件，
 *
 * @author Cyzc
 * @since [2022/08/19 23:59]
 */
public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());

        subject.notifyObservers(new Message("1","d第一条消息"));
    }

}
