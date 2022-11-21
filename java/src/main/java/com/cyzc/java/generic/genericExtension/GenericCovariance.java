package com.cyzc.java.generic.genericExtension;

import com.cyzc.java.generic.entity.Animal;
import com.cyzc.java.generic.entity.Cat;
import com.cyzc.java.generic.entity.Dog;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>GenericCovariance 泛型的协变
 *
 * @author Cyzc
 * @since [2022/08/15 23:55]
 */
public class GenericCovariance {

    public static void main(String[] args) {
        //
        List<? extends Animal> animals = new LinkedList<Animal>();
        List<? extends Animal> animals1 = new LinkedList<Dog>();
        List<? extends Animal> animals2 = new LinkedList<Cat>();

        // 以下四行代码都不能编译通过
        //animals.add(new Dog());
        //animals.add(new Cat());
        //animals.add(new Animal());
        //animals.add(new Object());


        //获取元素是否出错。取上层元素可以取出来
        Animal animal = animals.get(0);

        Dog animal1 = (Dog) animals.get(0);

       // Dog animal2 = animals1.get(0);

        //可以添加null，但没意义
        animals.add(null);
        // 可以安全地取出来


    }

}
