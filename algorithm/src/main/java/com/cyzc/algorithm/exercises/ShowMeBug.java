package com.cyzc.algorithm.exercises;

/**
 * <p>
 * /* You have three positive integers represented as string s1, s2 and s3. you need to return their
 * sum as string. Example 1: input: s1 = "5", s2 = "6", s3 = "7" output: "18" Example 2: input: s1 =
 * "1000", s2 = "10", s3 = "1" output: "1011" Example 3: input: s1 = "9999999999999999", s2 = "1",
 * s3 = "1" output: "10000000000000001" Constraints: 1 <= s1.length, s2.length, s3.length <= 100 do
 * not use other library(eg. BigInteger)
 * <p>
 * <p>
 * import java.util.*; // 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
 */
public class ShowMeBug {
    public static void main(String[] args) {
        System.out.println(sum("5", "6", "7"));
        System.out.println(sum("1000", "10", "1"));
        System.out.println(sum("9999999999999999", "1", "1"));
    }
    public static String sum(String s1, String s2, String s3) {
        int i1=s1.length();
        int i2=s2.length();
        int i3=s3.length();
        int temp=0;
        StringBuilder s=new StringBuilder();
        while(i1>=0||i2>=0||i3>=0||temp!=0){
            int x = i1 < 0 ? 0 : s1.charAt(i1--) - '0';
            int y = i2 < 0 ? 0 : s2.charAt(i2--) - '0';
            int z = i3 < 0 ? 0 : s3.charAt(i3--) - '0';

            int sum=x+y+z+temp;
            s.append(sum%10);
            temp=sum/10;
        }
        return s.reverse().toString();}
}