package com.cyzc.springboot.service.impl;

import com.cyzc.springboot.service.TestService;
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
public class TestServiceImpl implements TestService {


    private String testServiceName;

    public TestServiceImpl(String testServiceName) {
        this.testServiceName = testServiceName;
    }
}
