package com.cyzc.algorithm.dataStructure;

import java.util.Arrays;

/**
 * <p> 二维数组，数组的数组
 *
 * @author Cyzc
 * @since [2022/07/21 20:47]
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] ns = {
                {1,2,3},{2,3,4}
        };

        int[] arr0 = ns[0];
        System.out.println(Arrays.toString(arr0));
        System.out.println(arr0.length); // 4
    }
}
