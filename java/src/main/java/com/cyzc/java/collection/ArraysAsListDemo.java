package com.cyzc.java.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> 数组转换成集合还是有几点需要注意的，Array.asList 有坑
 *
 * @author Cyzc
 * @since [2022/11/19 17:19]
 */
public class ArraysAsListDemo {

    public static void main(String[] args) {
        //return new ArrayList<>(a); 是Arrays的静态内部类，没实现List的add方法，所以报错
        List<String> stringList = Arrays.asList("1", "2", "3", "4");
        stringList.add("1");


    }

}
