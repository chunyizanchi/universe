package com.cyzc.algorithm.leetcode;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/29 14:37]
 */
public class leetcode283 {

    public static void main(String[] args) {

        int [] arr={1,2,3,4,5,6,7,0,0};
        moveZeroes(arr);

    }



    public static void moveZeroes(int[] nums) {
        int left;
        int right = 0;
        for (left = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left + 1] = temp;
            }
        }
    }
}
