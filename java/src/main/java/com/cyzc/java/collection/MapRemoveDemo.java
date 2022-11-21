package com.cyzc.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/29 16:23]
 */
public class MapRemoveDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","00");

        String remove = map.remove("3");
        System.out.println(remove);

        List<String> a=new ArrayList<>();
        List<String> lists = a;
        lists.add("2");
    }

}
