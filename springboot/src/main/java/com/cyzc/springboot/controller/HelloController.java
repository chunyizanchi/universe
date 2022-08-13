package com.cyzc.springboot.controller;

import cn.hutool.core.date.StopWatch;
import com.cyzc.springboot.service.TestService;
import com.cyzc.springboot.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/15 22:33]
 */
@RestController
public class HelloController {

    @Lookup
    public TestService testService(){
        return null;
    };

    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi() {
        return "helloworld serviceName="+testService();
    }

    @Autowired
    public TestService testService;

    @RequestMapping(path = "hi2", method = RequestMethod.GET)
    public String hi2() {
        StopWatch stopWatch = StopWatch.create("1");
        String.valueOf(null);
        return "helloworld serviceName="+testService;
    }

    ;
}
