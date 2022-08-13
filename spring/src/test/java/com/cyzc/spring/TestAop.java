package com.cyzc.spring;

import com.cyzc.spring.aopdev.AppConfig;
import com.cyzc.spring.aopdev.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 16:42]
 */
public class TestAop {

    /**
     * 用于测试aop
     *
     * @param null
     * @return {@link }
     * @author cyzc
     * @since 2022/4/7 16:42
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.register();
        userService.login();

    }

}
