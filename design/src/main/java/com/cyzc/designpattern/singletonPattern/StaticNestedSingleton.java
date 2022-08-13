package com.cyzc.designpattern.singletonPattern;

import cn.hutool.core.lang.Singleton;
import java.io.Serializable;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/27 14:27]
 */
public class StaticNestedSingleton implements Serializable {

    private StaticNestedSingleton(){

    }

    public static StaticNestedSingleton getInstance(){
        return InnerClass.INSTANCE;
    }
    private static class InnerClass{
        private final static StaticNestedSingleton INSTANCE = new StaticNestedSingleton();
    }

    protected Object readResolve() {
        return getInstance();
    }
}
