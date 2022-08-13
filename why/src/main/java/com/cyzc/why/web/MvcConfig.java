package com.cyzc.why.web;

import com.cyzc.why.web.interceptor.WhyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/10 17:58]
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private WhyInterceptor whyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(whyInterceptor).addPathPatterns("/**");
    }


}
