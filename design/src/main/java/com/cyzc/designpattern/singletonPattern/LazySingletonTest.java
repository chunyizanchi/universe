package com.cyzc.designpattern.singletonPattern;

import cn.hutool.core.lang.Singleton;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/26 21:16]
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("多线程创建的单例：" + LazySingleton.getInstance());
            }).start();
        }
    }

}
