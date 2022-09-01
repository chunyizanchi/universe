package com.cyzc.dubbo.controller;

import com.cyzc.dubbo.domian.User;
import com.cyzc.dubbo.service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 23:44]
 */
@RestController
public class UserController {

    @Autowired
    private LocalUserService localUserService;

    @RequestMapping("findUser")
    public User findUser(Long id) {
        return localUserService.getById(id);
    }

    @RequestMapping("registerUser")
    public String register(User user) {
        localUserService.register(user);
        return "注册用户成功";
    }
}
