package com.cyzc.algorithm.leetcode;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 16:34]
 */
public class LeetCode400 {

    public static void main(String[] args) {
        final int nthDigit = findNthDigit(99);
        System.out.println(nthDigit);
    }


    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int last = 0;
        int ret;
        for (int i = 1, k = 1; ; i = i * 10, k++) {
            //9
            int cur = 9 * i * k;
            if (cur < 0 || n - last - cur < 0) {
                int time = (n - last - 1) / k;
                int next = i + time;
                String s = String.valueOf(next);
                int left = n - last - k * time;
                ret = Integer.parseInt(String.valueOf(s.charAt(left - 1)));
                break;
            }
            last += cur;
        }
        return ret;
    }
}
