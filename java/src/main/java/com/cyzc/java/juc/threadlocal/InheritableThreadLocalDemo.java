package com.cyzc.java.juc.threadlocal;

import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;

/**
 * <p>InheritableThreadLocal</p>
 * 可以从父线程向子线程传递私有变量
 *
 * @author Cyzc
 * @since [2021/12/22 10:16]
 */
public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
            itl.set("Thread a value");

            Thread b = new Thread(() -> {
                String str = itl.get();
                // 企图拿到父线程放进去的foo，成功了！因为tl是InheritableThreadLocal
                System.out.println(str);
            });

            b.start();

            // 子线程B启动后，父线程A休息3秒，确保子线程执行完毕 【一定确保子线程优于父线程执行完】
            try {
               Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 清理
            itl.remove();
        });

        a.start();
    }

}
