package com.cyzc.java.basic;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/06 14:26]
 */
public class StringTest {

    public static void main(String[] args) {
        String s0 = "abc";
        String s1 = new String("abc");
        String s2 = new String("abc");

        String intern = s1.intern();

        s2 = s2.intern();

        System.out.println(s0 == s1);

        System.out.println(s0 == intern);
        System.out.println(s0 == s2);
        System.out.println(s1==s2);

    }

}
