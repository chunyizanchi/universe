package com.cyzc.designpattern.proxyPattern.dynamicProxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/30 12:54]
 */
public class DynamicTest {

    public static void main(String[] args) {
        Custom custom = new Custom();
        //使用cglib 创建代理对象、

        final Custom deliveryClerk = (Custom) Enhancer.create(custom.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
                        if ("order".equals(method.getName())) {
                            final Object result = method.invoke(custom, args);
                            System.out.println("已获得订单");
                            return "MethodInterceptor:"+result;
                        }
                        return method.invoke(custom, args);
                    }
                });

        final Custom deliveryClerk2 = (Custom) Enhancer.create(custom.getClass(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        if ("order".equals(method.getName())) {
                            final Object result = method.invoke(custom, args);
                            System.out.println("已获得订单");
                            return "InvocationHandler:"+result;
                        }
                        return method.invoke(custom, args);
                    }
                });

        //写一个子类 继承 Custom。
        final String foodName = deliveryClerk2.order("饺子");
        System.out.println(foodName);

    }
}
