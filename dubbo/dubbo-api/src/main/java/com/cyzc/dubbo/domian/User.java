package com.cyzc.dubbo.domian;

import java.io.Serializable;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 22:05]
 */

public class User implements Serializable {


    Long id;

    String name;

    String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
