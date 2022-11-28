package com.cyzc.java.juc.sync.synchronize;

/**
 * <p>锁代码块反编译实例
 *
 * @author Cyzc
 * @since [2022/03/05 09:27]
 */
public class SynchronizedDemo1 {

    public void synBlock() {

        synchronized (this) {

            System.out.println("锁代码块");
        }

    }

}
