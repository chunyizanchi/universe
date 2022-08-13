package com.cyzc.java.juc.atomic;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 23:14]
 */

public class Employee {

    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee() {
    }

    public Employee(Integer id,String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
