package com.cyzc.spring.aop.cglib;

import com.cyzc.spring.bean.User;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 08:13]
 */
public class TestCglib {

    public static void main(String[] args) {
        //创建原始对象
        UserService userService = new UserService();
        /*
         * 使用cglib创建代理对象
         * Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         *
         *
         * Enhancer.create()
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(userService.getClass().getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor interceptor = new MethodInterceptor() {
            //等同于 invocationHandler 对象
            @Override
            public Object intercept(Object o, Method method, Object[] objects,
                    MethodProxy methodProxy) throws Throwable {
                System.out.println("==cglib log==");
                System.out.println(userService);
                System.out.println(args);
                Object invoke = method.invoke(userService, args);
                return invoke;
            }
        };
        enhancer.setCallback(interceptor);
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("ywb","970130");
       userService.register(new User());

    }
}
