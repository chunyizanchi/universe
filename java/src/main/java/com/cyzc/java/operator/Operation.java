package com.cyzc.java.operator;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/03 11:38]
 */
public class Operation {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 35;
        int d = 40;
        int e = 50;
        System.out.println("a + b = " + (a + b) );
        System.out.println("a - b = " + (a - b) );
        System.out.println("a * b = " + (a * b) );
        System.out.println("b / a = " + (b / a) );
        System.out.println("b % a = " + (b % a) );
        System.out.println("c % a = " + (c % a) );
        System.out.println("a++   = " +  (a++) );
        System.out.println("a--   = " +  (a--) );
        // 查看  d++ 与 ++d 的不同
        System.out.println("d++   = " +  (d++) );
        System.out.println("++d   = " +  (++d) );
    }
}
