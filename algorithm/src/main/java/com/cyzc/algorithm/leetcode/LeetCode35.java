package com.cyzc.algorithm.leetcode;

/**
 * <p> 输入插入的位置。
 *
 * @author Cyzc
 * @since [2022/06/13 15:35]
 */
public class LeetCode35 {

    public static void main(String[] args) {


    }
    /*输入: nums = [1,3,5,6], target = 5
    输出: 2

    示例2:
    输入: nums = [1,3,5,6], target = 2
    输出: 1

    示例 3:
    输入: nums = [1,3,5,6], target = 7
    输出: 4
*/

    public int out(int[] i,int target){

        int result=0;
        for (int j = 0; j < i.length; j++) {
            if (i[j]==target){
                result=j;
                break;
            }else if(i[j]<target&&target<i[j+1]){
                result=j+1;
            }
        }
        return result;
    }
}
