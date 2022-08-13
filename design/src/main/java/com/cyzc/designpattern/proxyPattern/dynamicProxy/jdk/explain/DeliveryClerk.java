package com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk.explain;

import com.cyzc.designpattern.proxyPattern.dynamicProxy.jdk.OrderInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 模拟 Proxy.newProxyInstance(ClassLoader loader,//代理类 Class<?>[] interfaces, //接口对象
 * InvocationHandler h)
 *
 * @author Cyzc
 * @since [2021/08/28 09:41]
 */
public class DeliveryClerk implements OrderInterface {

    //定义一个 InvocationHandler 局部变量
    private final InvocationHandler handler;

    public DeliveryClerk(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public String order(String foodName) {
        // 直接调用 InvocationHandler 的 invoke() 方法
        try {
            //因为是实现了接口的方法，所以直接从接口拿到 根据方法名 拿到 Method 对象。 调用的 是 order方法
            Method method = OrderInterface.class.getMethod("order",String.class);
            //使用 invoke 方法执行
            final Object invoke = handler.invoke(this, method, new Object[]{foodName});
            return (String) invoke;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void test1() {
        try {
            Method method = OrderInterface.class.getMethod("test1",String.class);
            handler.invoke(this, method, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void test2() {
        try {
            Method method = OrderInterface.class.getMethod("test2",String.class);
            handler.invoke(this, method, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
