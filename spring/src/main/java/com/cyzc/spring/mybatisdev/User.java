package com.cyzc.spring.mybatisdev;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/07 17:26]
 */
public class User {

    private String name;

    private String password;

    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
