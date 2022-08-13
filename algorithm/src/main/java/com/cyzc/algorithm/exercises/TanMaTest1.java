package com.cyzc.algorithm.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/21 21:51]
 */
public class TanMaTest1 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1232abc");
        list.add("1232abcd");
        list.add("123222abcd");

        List<String> strings = delRepeatEle(list);
    }


    public static List<String> delRepeatEle(List<String> list){
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            String s = list.get(i);
            String numberOnly= s.replaceAll("[^0-9]", "");
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                String j1 = list.get(j);
                String numberOnly2= j1.replaceAll("[^0-9]", "");
                if  (numberOnly.equals(numberOnly2))  {
                    list.remove(j);
                }
            }
        }
        return list;
    }
}

