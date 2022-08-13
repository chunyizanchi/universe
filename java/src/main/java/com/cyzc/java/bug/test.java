package com.cyzc.java.bug;

import java.util.HashMap;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/12 14:38]
 */
public class test {

    public static void main(String[] args) {





    }

    public String returnS(String s){

        int length = s.length();
        int left=0;
        int right=0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (right< length){
            if (map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(right))+1);
                //Math.max();
                map.put(s.charAt(right),right);
            }
        }
        return null;
    }

}
