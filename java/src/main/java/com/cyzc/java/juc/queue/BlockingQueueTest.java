package com.cyzc.java.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/21 11:25]
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {

            while (true) {

                try {
                    queue.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        new Thread(producer).start();

        new Thread(producer).start();

        Runnable consumer = () -> {

            while (true) {

                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        new Thread(consumer).start();

        new Thread(consumer).start();
    }

}
