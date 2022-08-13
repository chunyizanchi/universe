package com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/27 23:54]
 */
public class DynamicTest {

    public static void main(String[] args) {
        //目标类对象
        Custom custom = new Custom();
        //使用接口接收
        final OrderInterface orderInterface = (OrderInterface) Proxy.newProxyInstance(
                custom.getClass().getClassLoader(),
                custom.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    //逻辑增强
                    if ("order".equals(method.getName())) {
                        System.out.println(method.getName() + "方法执行了");
                        return method.invoke(custom, args1);
                    } else {
                        System.out.println(method.getName() + "方法执行了");
                        return method.invoke(custom, args1);
                    }
                });

        final String foodName = orderInterface.order("红烧茄子");
        orderInterface.test1();
        custom.order("红烧茄子");
        //System.out.println(foodName);

    }
}
