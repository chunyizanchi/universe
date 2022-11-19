package com.cyzc.java.string;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * <p> // TODO: 2022/11/17  JVM 中的intern 需要回顾一下，补一下日记
 *
 * @author Cyzc
 * @since [2022/11/17 16:17]
 */
public class StringInternDemo {

    public static void main(String[] args) {
        String a=new String("aaa");
        String b=new String("aaa");
        System.out.println(a==b);
        String intern = a.intern();
        System.out.println("intern:"+intern);
        System.out.println(intern==b.intern());
        System.out.println(a.intern()==intern);


    }

}
