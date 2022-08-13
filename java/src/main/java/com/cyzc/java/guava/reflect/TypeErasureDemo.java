package com.cyzc.java.guava.reflect;

import com.google.common.collect.Lists;
import java.util.ArrayList;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/23 13:58]
 */

public class TypeErasureDemo {

    public static void main(String[] args) {
        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));
// returns true, even though ArrayList<String> is not assignable from ArrayList<Integer>
    }

}
