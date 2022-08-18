package com.cyzc.springboot.service.impl;

import com.cyzc.springboot.request.TestRequest;
import com.cyzc.springboot.response.TestResponse;
import com.cyzc.springboot.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/15 23:53]
 */
@Service
@Scope(value="prototype",proxyMode= ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class TestServiceImpl implements TestService {


    private String testServiceName;
    //构造方法注入
    public TestServiceImpl(String testServiceName) {
        this.testServiceName = testServiceName;
    }


    @Override
    public TestResponse returnTest(TestRequest request) {
        log.info("request succeed");
        return TestResponse.builder()
                .result("testId="+request.getTestId())
                .build();
    }
}
