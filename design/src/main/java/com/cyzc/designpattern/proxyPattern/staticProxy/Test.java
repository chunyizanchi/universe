package com.cyzc.designpattern.proxyPattern.staticProxy;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/27 23:28]
 */
public class Test {

    public static void main(String[] args) {


        Custom custom=new Custom();

        OrderInterface source=new Deliverer2(custom);

        final String result = source.order("麻辣拌");

        System.out.println(result);
    }

}
