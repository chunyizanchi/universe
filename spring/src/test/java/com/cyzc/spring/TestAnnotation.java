package com.cyzc.spring;

import com.cyzc.spring.annotationdev.bean.User;
import com.cyzc.spring.annotationdev.lazy.Account;
import com.cyzc.spring.annotationdev.scope.Customer;
import com.cyzc.spring.configuration.AppConfig;
import com.cyzc.spring.injection.Category;
import com.cyzc.spring.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 17:08]
 */
public class TestAnnotation {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-annotation.xml");
        User user = (User) context.getBean("userService");
        System.out.println(user);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-annotation.xml");
        Customer customer = (Customer) context.getBean("customer");
        Customer customer2 = (Customer) context.getBean("customer");
        System.out.println(customer);
        System.out.println(customer2);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-annotation.xml");
        Account account = (Account) context.getBean("account");
    }

    //测试生命周期相关注解
    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-annotation.xml");
        //Product product = (Product) context.getBean("product");
        context.close();
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext-annotation.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.register();
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext-annotation.xml");
        Category userServiceImpl = (Category) context.getBean("category");
        System.out.println(userServiceImpl);
        System.out.println(userServiceImpl.getId());
        System.out.println(userServiceImpl.getName());

    }

    @Test
    public void test7() {
        int i = 1;
        int j = 2;
        // \i=j
        System.out.println(i);
        System.out.println(j);

    }

    @Test
    public void test8() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext-annotation.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test9() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
