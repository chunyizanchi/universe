package com.cyzc.dubbo.service.impl;

import com.cyzc.dubbo.domian.User;
import com.cyzc.dubbo.service.LocalUserService;
import com.cyzc.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 23:42]
 */
@Service
public class LocalUserServiceImpl implements LocalUserService {


    /**
     * 远程服务的接口。通过注解@DubboReference实现动态代理创建
     * 规则：
     * 1、 通知Dubbo框架，根据配置找注册中心，发现服务的地址。
     *    拿接口名称作为zookeeper中节点的命名规则，获取地址。
     * 2、 通知Spring，根据Dubbo框架的特性，创建接口的动态代理对象，并维护
     *    在Spring容器中。
     * 3、 类似@Autowired，把代理对象注入到当前的变量中。
     */
    @DubboReference
    private UserService userService;
    @Override
    public void register(User user) {
        System.out.println("准备调用远程服务，服务对象类型是：" + userService.getClass().getName());
        System.out.println("注册的用户是： " + user);
        userService.register(user);
    }
    @Override
    public User getById(Long id) {
        System.out.println("根据主键查询用户，主键是： " + id);
        return userService.getUserById(id);
    }
}
