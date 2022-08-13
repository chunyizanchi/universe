package com.cyzc.why;

import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Test;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/13 10:18]
 */
public class LinkedBlockingQueueTest {

    @Test
    public void test1() throws InterruptedException {
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
                        .filter(o -> o == null)
                        .findFirst()
                        .isPresent();
                Thread.sleep(100);
                System.out.println("finish scan, i still alive");
            }
        }


}
