package com.cyzc.designpattern.singletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  饿汉式单例通过反射获取类的时候能打破这个类型
 *  <p>通过反射创建的实例com.cyzc.java.designPatterns.singletonPattern.HungrySingleton@5197848c</p>
 *  <p>正常创建的实例com.cyzc.java.designPatterns.singletonPattern.HungrySingleton@17f052a3</p>
 *  <p>正常创建的实例com.cyzc.java.designPatterns.singletonPattern.HungrySingleton@17f052a3</p>
 * @author Cyzc
 * @since [2021/12/26 20:46]
 */
public class HungrySingletonTest {


    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过法
        Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor(
                null);

        declaredConstructor.setAccessible(true);
        HungrySingleton hungrySingleton = declaredConstructor.newInstance();
        System.out.println("通过反射创建的实例" + hungrySingleton);
        System.out.println("正常创建的实例" + HungrySingleton.getInstance());
        System.out.println("正常创建的实例" + HungrySingleton.getInstance());



    }
}
