package com.cyzc.spring.beanpost;

import org.springframework.beans.factory.InitializingBean;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/30 22:25]
 */
public class Category {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
