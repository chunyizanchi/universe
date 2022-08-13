package com.cyzc.spring.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 18:56]
 */
@Component
@PropertySource("classpath:init.properties")
public class Category {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
