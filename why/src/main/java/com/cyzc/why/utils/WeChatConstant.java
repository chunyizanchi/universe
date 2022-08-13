package com.cyzc.why.utils;

import com.cyzc.why.service.TestService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/25 14:52]
 */
@Component
public class WeChatConstant {


    @Autowired
    private static TestService testService;

    @Autowired
    private ApplicationContext applicationContext;

    public static WeChatConstant weChatConstant;

    public static void test(){
        System.out.println("进入工具类");

        testService.test();
    }

    @PostConstruct
    public void init(){
        weChatConstant=this;
        weChatConstant.testService=this.testService;
    }
}
