package com.cyzc.designpattern.singletonPattern;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/27 14:31]
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething(String str){
        System.out.println(str);
    }

}
