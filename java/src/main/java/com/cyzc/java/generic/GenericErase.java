package com.cyzc.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/17 10:37]
 */
public class GenericErase {

    public static void main(String[] args) {

        List<String> list1=new ArrayList<>();
        List<Integer> objects = new ArrayList<>();

        Class<? extends List> aClass = list1.getClass();
        Class<? extends List> aClass1 = objects.getClass();


        System.out.println(aClass1);//class java.util.ArrayList
        System.out.println(aClass);//class java.util.ArrayList

    }

}
