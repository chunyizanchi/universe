package com.cyzc.spring.aspect;

import com.cyzc.spring.bean.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/01 13:41]
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
        //this 原始对象调用，不会引用切面。
        //需要获取userService 的代理对象
        ((UserServiceImpl) AopContext.currentProxy()).login("11", "22");
       // UserService userService = (UserService) context.getBean("userService");
       // userService.login("11", "222");
    }

    @Override
    public void login(String userName, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
