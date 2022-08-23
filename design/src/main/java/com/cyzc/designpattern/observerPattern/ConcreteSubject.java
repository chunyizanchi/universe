package com.cyzc.designpattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/19 23:58]
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
