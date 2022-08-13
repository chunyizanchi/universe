package com.cyzc.spring.configuration;

import com.cyzc.spring.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 11:01]
 */
@Configuration
/*@ComponentScan(basePackages = "com.cyzc.spring.componentScan", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class}),
        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "*..User1")
})*/
/*@ComponentScan(basePackages = "com.cyzc.spring.componentScan",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})})*/
@ComponentScan(basePackages = "com.cyzc.spring.componentScan")
@Import(User.class)
public class AppConfig1 {


}
