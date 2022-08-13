package com.cyzc.spring.aop.jdk;

import com.cyzc.spring.bean.User;
import com.cyzc.spring.proxy.UserService;
import com.cyzc.spring.proxy.UserServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 17:55]
 */
public class TestJDKProxy {

    public static void main(String[] args) {
        //创建原始对象
        UserService userService = new UserServiceImpl();
        //jdk 创建动态代理对象
        //Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        //需要借用一个类加载器，因为代理类需要类加载器加载到JVM中，类加载器选择当前类，或者当前域的类加载器就行，没有限制
        // 类加载器，原始对象实现的接口，invocationHandler
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Proxy.newProxyInstance.invoke");
                //原始方法运行
                Object invoke = method.invoke(userService, args);

                return invoke;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("gx","970106");
        userServiceProxy.register(new User());
    }
}
