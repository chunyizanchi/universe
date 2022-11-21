package com.cyzc.java.collection;

import java.util.ArrayList;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/20 15:19]
 */
public class FinalListDemo {

    public static void main(String[] args) {

        final ArrayList<String> objects = new ArrayList<>();
        objects.add("111");

        System.out.println(objects);

    }

}
