package com.cyzc.spring;

import com.cyzc.spring.extension.MyEnableAutoConfiguration;
import java.util.List;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 14:48]
 */
public class TestSpringFactoriesLoader {

    public static void main(String[] args) {
        List<String> classNames = SpringFactoriesLoader.loadFactoryNames(
                MyEnableAutoConfiguration.class, MyEnableAutoConfiguration.class.getClassLoader());
        classNames.forEach(System.out::println);
    }
}
