package com.cyzc.java.juc.threadlocal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <p> 雄哥自定义的线程池中可使用的 threadlocal
 *
 * @author Cyzc
 * @since [2021/12/22 23:33]
 */
public class MyThreadLocal<T> extends ThreadLocal<T>{

    private static MyThreadLocal<HashSet<MyThreadLocal<Object>>> holder =
            new MyThreadLocal<HashSet<MyThreadLocal<Object>>>() {
                @Override
                protected HashSet<MyThreadLocal<Object>> initialValue() {
                    return new HashSet<>();
                }
            };


    @Override
    public void set(T value) {
        super.set(value);
        addThisToHolder();
    }

    private void addThisToHolder() {
        if (!holder.get().contains(this)) {
            holder.get().add((MyThreadLocal<Object>) this);
        }
    }

    @Override
    public void remove() {
        super.remove();
        removeThisFromHolder();
    }

    private void removeThisFromHolder() {
        holder.get().remove(this);
    }

    public static class DataTransmit {

        public static Map<ThreadLocal<Object>, Object> capture() {
            Map<ThreadLocal<Object>, Object> threadLocalValues = new HashMap<>();
            for (MyThreadLocal<Object> threadLocal : holder.get()) {
                threadLocalValues.put(threadLocal, threadLocal.get());
            }
            return threadLocalValues;
        }

        // 重放，用快照去覆盖当前线程的ThreadLocalMap
        public static Object replay(Object obj) {
            Map<ThreadLocal<Object>, Object> threadLocalValues = (Map<ThreadLocal<Object>, Object>)obj;

            Map<ThreadLocal<Object>, Object> backup = new HashMap<>();
            for (ThreadLocal<Object> threadLocal : threadLocalValues.keySet()) {
                backup.put(threadLocal, threadLocal.get());
            }

            for (Map.Entry<ThreadLocal<Object>, Object> entry : threadLocalValues.entrySet()) {
                ThreadLocal<Object> threadLocal = entry.getKey();
                threadLocal.set(entry.getValue());
            }

            return backup;
        }

        public static void restore(Object obj) {
            Map<ThreadLocal<Object>, Object> backup = (Map<ThreadLocal<Object>, Object>) obj;

            for (Map.Entry<ThreadLocal<Object>, Object> entry : backup.entrySet()) {
                ThreadLocal<Object> threadLocal = entry.getKey();
                threadLocal.set(entry.getValue());
            }
        }
    }
}
