package com.cyzc.java.generic.genericErase;

import com.cyzc.java.generic.entity.Animal;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 泛型擦除，需要注意在jvm运行时被擦除成什么了 <br>
 * <?> 无限制通配符被擦除成 Object <br>
 * <? extends T> 被擦除成T  extends 关键字声明类型的上界，表示参数化的类型，可能是所指定的类型，也可能是该类型的子类。<br>
 * <? super T> 被擦除成Object super 关键字声明类型的下界，表示参数化的类型可能是所制定的类型，或者是此类型的父类。<br>
 *
 * @author Cyzc
 * @since [2022/08/17 10:37]
 */
public class GenericErase {

    //如何证明泛型被擦除了
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1. 获取对象类型
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);

        System.out.println(stringList.getClass() == integerList.getClass()); // true
        System.out.println(stringList.getClass());//class java.util.ArrayList
        System.out.println(integerList.getClass());//class java.util.ArrayList

        //2. 根据反射
        integerList.getClass().getMethod("add", Object.class).invoke(integerList, "123");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }




    }

}
