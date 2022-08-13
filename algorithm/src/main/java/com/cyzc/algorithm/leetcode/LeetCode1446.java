package com.cyzc.algorithm.leetcode;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 16:33]
 */
public class LeetCode1446 {

    public static void main(String[] args) {
        final int aaslkasdlsad = maxPower("aaslkasdlsad");
        System.out.println(aaslkasdlsad);
    }

    public static int maxPower(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        //第一个元素
        char c = s.charAt(0);
        int result = 1;
        int currentLength = 1;
        for (int i = 1; i < length; i++) {
            if (c == s.charAt(i)) {
                currentLength++;
            } else {
                c = s.charAt(i);

                currentLength = 1;
            }
            result = Math.max(result, currentLength);
        }
        return result;
    }
}
