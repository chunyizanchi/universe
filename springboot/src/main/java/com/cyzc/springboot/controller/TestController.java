package com.cyzc.springboot.controller;

import com.cyzc.base.web.InterfaceController;
import com.cyzc.base.web.Response;
import com.cyzc.springboot.request.TestRequest;
import com.cyzc.springboot.response.TestResponse;
import com.cyzc.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 22:05]
 */
@RestController
public class TestController implements InterfaceController {


    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public Response<TestResponse> testController(TestRequest testRequest) {
        return tryFunction(testRequest,()->testService.returnTest(testRequest));
    }
}
