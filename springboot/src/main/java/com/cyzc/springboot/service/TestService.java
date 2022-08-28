package com.cyzc.springboot.service;

import com.cyzc.springboot.request.TestRequest;
import com.cyzc.springboot.response.TestResponse;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/15 23:53]
 */
public interface TestService {

    TestResponse returnTest(TestRequest request) throws Exception;
}
