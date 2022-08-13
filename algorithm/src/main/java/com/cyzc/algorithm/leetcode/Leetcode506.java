package com.cyzc.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 16:32]
 */
public class Leetcode506 {

    public static void main(String[] args) {
        int[] score = {6, 4, 3, 8, 2, 1};

        final String[] relativeRanks = findRelativeRanks(score);
        final String[] relativeRanks2 = findRelativeRanks2(score);
        System.out.println(Arrays.toString(relativeRanks));
        System.out.println(Arrays.toString(relativeRanks2));
    }

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];
        Map<Integer, Integer> sortMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            //分数 ：下标
            sortMap.put(score[i], i);
        }
        //排序
        Integer[] sort = sortMap.keySet().toArray(new Integer[n]);
        for (int i = 0; i < n; i++) {
            //result[] sort[]
            Integer key = sort[i];
            if (i == 0) {
                result[sortMap.get(key)] = "Gold Medal";
            } else if (i == 1) {
                result[sortMap.get(key)] = "Silver Medal";
            } else if (i == 2) {
                result[sortMap.get(key)] = "Bronze Medal";
            } else {
                result[sortMap.get(key)] = (i + 1) + "";
            }
        }
        return result;


    }

    public static String[] findRelativeRanks2(int[] score) {

        int n = score.length;
        String[] result = new String[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //分数 ：下标
            map.put(score[i], i);
        }
        //排序
        Integer[] sort = map.keySet().toArray(new Integer[n]);
        Arrays.sort(sort, (a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            Integer key = sort[i];
            if (i == 0) {
                result[map.get(key)] = "Gold Medal";
            } else if (i == 1) {
                result[map.get(key)] = "Silver Medal";
            } else if (i == 2) {
                result[map.get(key)] = "Bronze Medal";
            } else {
                result[map.get(key)] = (i + 1) + "";
            }
        }
        return result;


    }
}
