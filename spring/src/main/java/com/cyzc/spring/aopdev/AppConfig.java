package com.cyzc.spring.aopdev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 16:04]
 */
@Configuration
@ComponentScan(basePackages = "com.cyzc.spring.aopdev")
//proxyTargetClass=true  cglib
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {

}
