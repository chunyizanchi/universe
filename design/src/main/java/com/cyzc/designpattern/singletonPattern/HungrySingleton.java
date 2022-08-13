package com.cyzc.designpattern.singletonPattern;

/**
 * <p>饿汉式单例：类加载的时候即创建：不支持延迟加载</p>
 *  优点：线程安全，没有加锁，执行效率比较高
 *  缺点：不是懒加载，类加载时就初始化，浪费内存空间
 *
 * @author Cyzc
 * @since 2021-08-10
 */
public class HungrySingleton {
    //类加载的时候即创建实例，而不是new对象的时候创建实例 被 **final** 修饰了
    private static final HungrySingleton instance=new HungrySingleton();
    //私有的构造器
    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return instance;
    }


}