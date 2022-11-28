package com.cyzc.java.juc.sync.synchronize;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/05 09:32]
 */
public class SynchronizedDemo2 {

    public synchronized void testSync(){
        LockSupport.park();
        System.out.println("锁普通方法");
    }

}
