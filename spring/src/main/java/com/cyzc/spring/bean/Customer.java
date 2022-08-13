package com.cyzc.spring.bean;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/30 08:31]
 */
public class Customer {
    private String name;

    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
