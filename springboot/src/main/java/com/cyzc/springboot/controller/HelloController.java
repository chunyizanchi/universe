package com.cyzc.springboot.controller;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.UUID;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cyzc.springboot.entity.TpExternalActSource;
import com.cyzc.springboot.service.TestService;
import com.cyzc.springboot.service.impl.TpExternalActSourceServiceImpl;

import org.slf4j.LoggerFactory;
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



    Log log= LogFactory.get();
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


    @Autowired
    private TpExternalActSourceServiceImpl tpExternalActSourceService;
    @RequestMapping(path = "hi3", method = RequestMethod.GET)
    public String hi3() {
        UUID uuid = UUID.randomUUID();
        TpExternalActSource tpExternalActSource=new TpExternalActSource();
        tpExternalActSource.setExternalActSourceId(uuid.toString());
        tpExternalActSource.setIsNew("1");
        //tpExternalActSource.insert();
        System.out.println("save 方法执行前");
        tpExternalActSourceService.save(tpExternalActSource);
        System.out.println("save 方法执行后");
        return null;
    }

}
