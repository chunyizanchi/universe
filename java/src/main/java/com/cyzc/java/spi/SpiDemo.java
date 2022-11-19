package com.cyzc.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <p> Java 的Spi是"META-INF/services/" 文件夹下，现在项目中顶
 * 使用：
 * 1. 定义目录
 * 2. 目录文件下放配置文件
 * 3. 定义接口及其实现
 * 4. ServiceLoader.load(Search.class) 获取ServiceLoader集合，然后遍历调用方法。
 *
 * 由上可以得知：弊端
 * 需要遍历所有实现并且实例化，在循环中才能找到具体的实现，只能通过Iterator 获取，
 * 多线程情况下ServiceLoader 非线程安全
 *
 * @author Cyzc
 * @since [2022/11/19 09:25]
 */
public class SpiDemo {

    public static void main(String[] args) {

        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        for (Search next : load) {
            next.searchDoc("hello Spi");
        }

    }

}
