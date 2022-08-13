package com.cyzc.designpattern.proxyPattern.dynamicProxy.cglib.explain;

import com.cyzc.designpattern.proxyPattern.dynamicProxy.cglib.Custom;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * DeliveryClerk Enhancer.create(Class class,Callback callback)
 *
 * @author Cyzc
 * @since [2021/08/30 13:20]
 */
public class DeliveryClerk extends Custom {

    MethodInterceptor methodInterceptor;

    public DeliveryClerk(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public String order(String foodName) {

        try {
            Method method = Custom.class.getMethod("order", String.class);

            final Object result = methodInterceptor.intercept(this, method, new Object[]{foodName},
                    null);

            return (String) result;
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return super.order(foodName);
    }

    @Override
    public void test1() {
        try {
            Method method = Custom.class.getMethod("test1", String.class);

            final Object result = methodInterceptor.intercept(this, method, null,
                    null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        super.test1();
    }

    @Override
    public void test2() {
        try {
            Method method = Custom.class.getMethod("test2", String.class);

            final Object result = methodInterceptor.intercept(this, method, null,
                    null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        super.test2();
    }
}
