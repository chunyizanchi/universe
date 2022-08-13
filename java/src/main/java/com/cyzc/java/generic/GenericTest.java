package com.cyzc.java.generic;

import java.util.Set;

/**
 * 通配符类型是安全的，原生态类型不安全，很容易破坏类型集合的约束条件
 *
 * @author Cyzc
 * @since [2021/12/03 00:54]
 */
public class GenericTest {

    public static void main(String[] args) {

       Pair stringPair=new Pair<>();
       stringPair.setFirst("2");
       stringPair.setSecond(1.22221212);

        final Class<?> aClass = stringPair.getSecond().getClass();
        System.out.println(aClass);

        System.out.println(stringPair);

    }
    @SuppressWarnings("unchecked")
    public void testSet(Set<?> s1,Set<?> s2){

    }

}
