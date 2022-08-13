package com.cyzc.designpattern.proxyPattern.dynamicProxy.cglib;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/30 12:54]
 */
public class Custom {

    public String order(String foodName) {
        return "已经下单点了" + foodName;
    }


    public void test1() {
        System.out.println("我是test方法");
    }


    public void test2() {

    }
}
