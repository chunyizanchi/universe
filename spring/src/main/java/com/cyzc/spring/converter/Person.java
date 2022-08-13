package com.cyzc.spring.converter;

import java.util.Date;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/30 21:54]
 */
public class Person {

    private String name;

    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
