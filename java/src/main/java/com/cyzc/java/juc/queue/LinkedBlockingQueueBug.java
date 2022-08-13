package com.cyzc.java.juc.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/13 10:22]
 */
public class LinkedBlockingQueueBug {
    public static void main(String[] args) throws Exception {

        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    queue.offer(new Object());
                    queue.remove();
                }
            }).start();
        }
        while (true) {
            System.out.println("begin scan, i still alive");
            queue.stream()
                    .anyMatch(o -> o == null);
            Thread.sleep(100);
            System.out.println("finish scan, i still alive");
        }
    }
}
