package com.cyzc.designpattern.observerPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 21:56]
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
