package com.cyzc.java.generic.genericExtension;

import com.cyzc.java.generic.entity.Animal;
import com.cyzc.java.generic.entity.Biology;
import com.cyzc.java.generic.entity.Cat;
import com.cyzc.java.generic.entity.Dog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Required;

/**
 * <p> <? super T>  被设计用来添加元素，只能添加T 类型和 其子类型的元素。生产场景->消费场景  错误
 *  消费吗不是
 * @author Cyzc
 * @since [2022/08/15 23:20]
 */
public class GenericInverterDemo {

    public static void main(String[] args) {
        List<? super Animal> animals = new LinkedList<Biology>();
        /**
         *
         *
         *
         *
         *
         */
        // keypoint: 2022/11/19
        //有一点眉目了。首先我们生命一个泛型集合的时候是怎么生命的，ide帮我们默认去掉了
        // <? super Animal> 添加的类型只能是 Animal及其父类，的意思是，我后面实例化传入的泛型需要是Animal及其父类 而不是我添加的元素需要是 Animal及其父类
        //List<? super Animal> animals = new LinkedList<>();
        // java 数组的协变有什么问题，添加元素的时候
        List<? extends Animal> extendsAnimals = new LinkedList<Cat>();
        //可以添加元素。添加的元素需要是  Animal的子类或者是Animal类
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Animal());
        /*
        * Required type:capture of ? super Animal
        * Provided:Biology
        */
        //animals.add(new Biology());
        //编译报错。
        Object object = animals.get(0);
        System.out.println(object);

        animals.forEach(System.out::println);
    }

}
