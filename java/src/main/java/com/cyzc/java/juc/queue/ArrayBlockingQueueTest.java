package com.cyzc.java.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p> 抛出异常： add,remove,element
 * <p> 不抛出异常： offer,poll,peek
 * <p>阻塞： put,take
 *
 * @author Cyzc
 * @since [2022/03/21 09:49]
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(2);
        blockingQueue.add(1);
        blockingQueue.add(1);
        System.out.println("blockingQueue.offer(1):" + blockingQueue.offer(1));
        System.out.println("blockingQueue.element()" + blockingQueue.element());
        blockingQueue.put(1);

        //blockingQueue.add(1);  IllegalStateException: Queue full
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove(); NoSuchElementException
        blockingQueue.poll();
        System.out.println("blockingQueue.poll():" + blockingQueue.poll());


    }

}
