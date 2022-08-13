package com.cyzc.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 16:31]
 */
public class LeetCode1816 {

    public static void main(String[] args) {
        String rsult = truncateSentence2("Hello how are you Contestant",
                4);
        System.out.println(rsult);
    }


    public static String truncateSentence2(String s, int k) {
        String[] s1 = Arrays.copyOf(s.split(" "), k);
        return String.join(" ", s1);
    }
}
