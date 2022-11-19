package com.cyzc.java.generic.genericFunction;

import com.cyzc.java.generic.entity.GenericClass;

/**
 * <p> 泛型方法的定义
 *  <T> T funcName(T t){
 *      return t;
 *  }
 *  为什么要使用泛型方法呢？因为泛型类要在实例化的时候就指明类型，如果想换一种类型，不得不重新new一次，可能不够灵活；
 *  而泛型方法可以在调用的时候指明类型，更加灵活
 * @author Cyzc
 * @since [2022/11/18 15:14]
 */
public class GenericFunctionDemo {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        GenericClass<String> genericClass=new GenericClass<>("hello generic function");
        //调用的时候指明类型
        String s = genericClass.showGenericClass("1234");
        Integer integer = genericClass.showGenericClass(1234);

        Object object = genericClass.getObject(
                Class.forName("com.cyzc.java.generic.genericClass.Pair"));
        System.out.println(object);

    }

}
