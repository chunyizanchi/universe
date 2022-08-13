package com.cyzc.java.collection;

import java.util.concurrent.ConcurrentHashMap;



public class CurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "10000000000000000");
        String putIfAbsent = concurrentHashMap.putIfAbsent("1", "2");
        concurrentHashMap.putIfAbsent("1","3");
        concurrentHashMap.putIfAbsent("1","4");
        String s1 = concurrentHashMap.get("1");
        System.out.println(s1);
        String s = concurrentHashMap.putIfAbsent("2", "4");
        System.out.println(putIfAbsent);
        System.out.println(s);
    }

}
