package com.cyzc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/13 16:30]
 */
public class LeetCode383 {

    public static void main(String[] args) {
        final boolean b = get("a", "b");
        System.out.println(b);
    }


    public static boolean get(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        String[] ransomNoteArr = ransomNote.split("");
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(ransomNoteArr));

        String[] magazineArr = magazine.split("");
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(magazineArr));
        return list2.retainAll(list1);

    }
}
