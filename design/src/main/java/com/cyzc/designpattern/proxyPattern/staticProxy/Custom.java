package com.cyzc.designpattern.proxyPattern.staticProxy;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/27 23:18]
 */
public class Custom implements OrderInterface{

    @Override
    public String order(String foodName) {
        return "已经下单点了"+foodName;
    }

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }
}
