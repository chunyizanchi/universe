package com.cyzc.why.service.impl;

import com.cyzc.why.service.TestService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/25 15:03]
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("test");
    }
}
