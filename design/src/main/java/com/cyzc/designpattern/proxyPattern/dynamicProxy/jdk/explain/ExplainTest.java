package com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk.explain;

import com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk.Custom;
import com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk.OrderInterface;
import java.lang.reflect.InvocationHandler;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/28 10:01]
 */
public class ExplainTest {

    public static void main(String[] args) {
        Custom custom = new Custom();

        InvocationHandler invocationHandler = (proxy, method, args1) -> {
            if ("order".equals(method.getName())) {
                System.out.println(method.getName() + "方法执行了");
                return method.invoke(custom, args1);
            } else {
                System.out.println(method.getName() + "方法执行了");
                return method.invoke(custom, args1);
            }
        };

        OrderInterface handler = new DeliveryClerk(invocationHandler);
        final String result = handler.order("芹菜猪肉馅饺子");

        System.out.println(result);
    }


}
