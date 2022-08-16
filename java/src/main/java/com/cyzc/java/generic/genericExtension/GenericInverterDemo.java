package com.cyzc.java.generic.genericExtension;

import com.cyzc.java.generic.entity.Animal;
import com.cyzc.java.generic.entity.Cat;
import com.cyzc.java.generic.entity.Dog;
import java.util.LinkedList;
import java.util.List;

/**
 * <p> <? super T>  被设计用来添加元素，只能添加T 类型和 其子类型的元素。生产场景
 *
 * @author Cyzc
 * @since [2022/08/15 23:20]
 */
public class GenericInverterDemo {

    public static void main(String[] args) {

        List<? super Animal> animals = new LinkedList<>();
        //可以添加元素。添加的元素需要时  Animal的子类或者是Animal类
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Animal());
        //编译报错。


        Object object = animals.get(0);

    }

}
