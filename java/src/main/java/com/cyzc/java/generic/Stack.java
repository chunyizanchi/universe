package com.cyzc.java.generic;

import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/15 23:32]
 */
public class Stack<E> {

    //private E e;

    public E put(List<? extends E> list) {
        E e = null;
        return e;
    }

    public void push(E e) {

    }

    public Stack() {

    }


    public void pushAll(Iterable<E> src) {

        for (E e : src) {
            push(e);
        }

    }

}
