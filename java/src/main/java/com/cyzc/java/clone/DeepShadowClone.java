package com.cyzc.java.clone;

import com.cyzc.java.entity.CloneTest;
import org.checkerframework.checker.units.qual.C;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/03 15:25]
 */
public class DeepShadowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅拷贝
        CloneTest cloneTest=new CloneTest();
        cloneTest.setAddress("1");
        cloneTest.setCity("1");
        //直接赋值
        CloneTest cloneTest1=cloneTest;
        cloneTest1.setAddress("2");

        System.out.println("cloneTest"+cloneTest);
        System.out.println("cloneTest1"+cloneTest1);

        //深拷贝
        CloneTest cloneTest2= (CloneTest) cloneTest.clone();
        cloneTest2.setAddress("3");
        System.out.println("cloneTest"+cloneTest);
        System.out.println("cloneTest2"+cloneTest2);



    }

}
