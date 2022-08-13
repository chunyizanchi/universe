package com.cyzc.java.entity;

import lombok.Data;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/16 19:10]
 */
@Data
public class Student {

    private String name;

    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}
