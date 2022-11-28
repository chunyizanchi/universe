package com.cyzc.java.reflection;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/18 23:39]
 */
public class ReflectionDemo {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //获取类的方式
        System.out.println(SuperClass.class);
        System.out.println(new SuperClass().getClass());
        System.out.println(Class.forName("com.cyzc.java.reflection.SuperClass"));

        Class<?> subClass = Class.forName("com.cyzc.java.reflection.SubClass");
        System.out.println(subClass.getName());
        System.out.println(subClass.getSimpleName());
        System.out.println(subClass.newInstance());

        Class<?> superclass = subClass.getSuperclass();
        System.out.println(superclass.getName());
        //私有属性字段也可以获取
        Field[] fields = subClass.getDeclaredFields();
        //该方法只能获取public 字段
        Field[] fields1 = subClass.getFields();
        for (Field field : fields
        ) {
            System.out.println(field.getName());
        }
       /* for (Field field : fields1
        ) {
            System.out.println(field.getName());
        }*/

    }

}
