package com.cyzc.java.juc.threadlocal;

import com.cyzc.java.juc.threadlocal.MyThreadLocal;
import java.util.HashMap;
import java.util.Map;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/22 23:31]
 */
public class MyTask implements Runnable {

    private Runnable task;

    private final Map<ThreadLocal<Object>, Object> threadLocalValues;


    public MyTask(Runnable task) {
        this.task = task;
        threadLocalValues = MyThreadLocal.DataTransmit.capture();
    }

    @Override
    public void run() {
        Object backup = MyThreadLocal.DataTransmit.replay(threadLocalValues);
        try {
            task.run();
        } catch (Exception e) {
            MyThreadLocal.DataTransmit.restore(backup);
        }

    }
}
