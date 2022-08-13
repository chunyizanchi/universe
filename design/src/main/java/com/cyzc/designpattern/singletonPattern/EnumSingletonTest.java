package com.cyzc.designpattern.singletonPattern;

import cn.hutool.core.lang.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/27 14:34]
 */
public class EnumSingletonTest {

    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingleton enumSingleton=EnumSingleton.INSTANCE;
        enumSingleton.doSomething("hello enum");

        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(
                String.class, int.class);

        declaredConstructor.setAccessible(true);

        EnumSingleton enumSingleton2 = declaredConstructor.newInstance();
        System.out.println(enumSingleton2);
    }

}
