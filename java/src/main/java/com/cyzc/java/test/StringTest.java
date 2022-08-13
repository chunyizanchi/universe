package com.cyzc.java.test;

import com.cyzc.java.entity.Home;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/22 14:22]
 */
//@DisplayName("CurrentHashMapTest")
public class StringTest {

    //@Test
    public void testString(){
        String s1="cyzc";
        String s2="cyzc";
        s2="gx";
        System.out.println(s1.hashCode());
    }

    //@Test
    public void testFilter(){
        Home home=new Home("1","1");
        Home home1=new Home("2","3");
        Home home2=new Home("4","6");
        Home home3=new Home("-1","5");
        Home home4=new Home("7","2");
        ArrayList<Home> homes = Lists.newArrayList(home, home1, home2, home3, home4);

        List<Home> collect = homes.stream().filter(x -> {
            if (Integer.parseInt(x.getHomeAddr()) < 0) {
                return false;
            }
            return Integer.parseInt(x.getHomeAddr()) > 5;
        }).collect(Collectors.toList());

        boolean b = homes.stream().anyMatch(x -> x.getHomeAddr().equals("-1"));

        System.out.println(collect);
        System.out.println(b);
    }
}
