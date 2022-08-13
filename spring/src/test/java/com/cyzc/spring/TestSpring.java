package com.cyzc.spring;

import com.cyzc.spring.bean.Customer;
import com.cyzc.spring.bean.Person;
import com.cyzc.spring.beanpost.Category;
import com.cyzc.spring.factorybean.ConnectFactoryBean;
import com.cyzc.spring.scope.Account;
import com.cyzc.spring.service.UserService;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/29 21:31]
 */
public class TestSpring {

    @Test
    public void test3() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        Person person1 = applicationContext.getBean("person", Person.class);
        //bean 唯一，容器中必须只有一个bean
        //Person person2 = applicationContext.getBean( Person.class);
        System.out.println(person);
        System.out.println(person1);
        //System.out.println(person2);
    }


    @Test
    public void test4() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        //containsBean 能判断name,也能判断id
        boolean person = applicationContext.containsBean("person");
        System.out.println(person);
        //containsBeanDefinition 只能判断id,不能判断name
        boolean person1 = applicationContext.containsBeanDefinition("person");

        System.out.println(person1);
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Person secondName = (Person) context.getBean("secondName");
        Person person3 = (Person) context.getBean("person3");
        System.out.println(secondName);
        System.out.println(person3);
    }

    @Test
    public void test7() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        /*person.setSex("男");
        person.setName("yyy");*/
        System.out.println(person);
    }

    /**
     * JDK 类型赋值
     *
     * @return {@link }
     * @author cyzc
     * @since 2022/3/30 7:30
     */
    @Test
    public void test8() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email:" + email);
        }
        Set<String> tesl = person.getTesl();
        for (String tel : tesl) {
            System.out.println("tels:" + tel);
        }

        List<String> addresses = person.getAddresses();
        for (String address : addresses) {
            System.out.println("address:" + address);

        }

        Map<String, String> maps = person.getMaps();
        maps.forEach((k, v) -> {
            System.out.println("key:" + k);
            System.out.println("value:" + v);
        });

        Properties properties = person.getProperties();
        System.out.println("properties:" + properties);
        /*person.setSex("男");
        person.setName("yyy");*/
        System.out.println(person);
    }

    @Test
    public void test9() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");


    }

    /**
     * 构造器注入
     *
     * @author cyzc
     * @since 2022/3/30 8:34
     */
    @Test
    public void test10() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Customer customer = (Customer) applicationContext.getBean("customer");

        System.out.println(customer);
    }

    @Test
    public void test11() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Connection connection = (Connection) applicationContext.getBean("connection");
        Connection connection1 = (Connection) applicationContext.getBean("connection");

        System.out.println(connection);
        System.out.println(connection1);
    }

    /**
     * ConnectFactoryBean 测试
     *
     * @return {@link }
     * @author cy
     * @since 2022/3/30 16:59
     */
    @Test
    public void test12() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        ConnectFactoryBean connection = (ConnectFactoryBean) applicationContext.getBean(
                "&connection");

        System.out.println(connection);
    }

    /**
     * 用于测试实例工厂
     *
     * @return {@link }
     * @author cy
     * @since 2022/3/30 16:59
     */
    @Test
    public void test13() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Connection connection = (Connection) applicationContext.getBean(
                "connection");

        System.out.println(connection);
    }

    /**
     * 静态工厂创建bean
     *
     * @return {@link Void}
     * @author cyzc
     * @since 2022/3/30 17:47
     */
    @Test
    public void test14() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Connection connection = (Connection) applicationContext.getBean(
                "connection");

        System.out.println(connection);
    }

    /**
     * 测试单例bean
     *
     * @return {@link }
     * @author cyzc
     * @since 2022/3/30 17:52
     */
    @Test
    public void test15() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        Account account = (Account) applicationContext.getBean(
                "account");

        Account account1 = (Account) applicationContext.getBean(
                "account");

        Account account3 = (Account) applicationContext.getBean(
                "account");

        System.out.println(account);
        System.out.println(account1);
        System.out.println(account3);

    }
    /**
     * 对象创建 如果是单例bean那么在容器初始化的时候就创建对象，
     * 如果是多励bean，那么就是getBean的时候才创建。
     * 如果想要设置 singleton时不在容器启动的时候创建，那么久 设置一个lazy-init 属性
     * @author cyzc
     * @since 2022/3/30 18:06
     */
    @Test
    public void test16(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        /*Product product = (Product) applicationContext.getBean(
                "product");*/

    }
    /**
     * 初始化bean的方法
     * @author cyzc
     * @return {@link Void}
     * @since 2022/3/30 20:25
     */
    @Test
    public void test17(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
        /*Product product = (Product) applicationContext.getBean(
                "product");*/
        applicationContext.close();
    }

    @Test
    public void test18(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext2.xml");
        Connection connection = (Connection)applicationContext.getBean("connection");

        System.out.println(connection);
    }

    /**
     * 测试自定义
     * @author cyzc
     * @since 2022/3/30 21:59
     */
    @Test
    public void test19(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext1.xml");
        Person person = (Person)applicationContext.getBean("person");

    }


    /**
     * BeanPostProcessor
     * @author cyzc
     * @since 2022/3/30 21:59
     */
    @Test
    public void test20(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "/applicationContext3.xml");
        Category category = (Category)applicationContext.getBean("category");
        System.out.println(category.getName());

    }
}
