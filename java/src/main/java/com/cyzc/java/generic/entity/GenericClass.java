package com.cyzc.java.generic.entity;

import java.util.Collection;

/**
 * <p> 泛型类
 *
 * @author Cyzc
 * @since [2022/08/16 15:17]
 */
public class GenericClass<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public GenericClass() {
    }

    public GenericClass(T t) {
        this.t = t;
    }

    public <T> T showGenericClass(T t) {
        System.out.println("showGenericClass value :" + t);

        System.out.println("t.Class:" + t.getClass());
        return t;
    }

    public <T> T getObject(Class<T> t) throws InstantiationException, IllegalAccessException {
        System.out.println("getObject " + t);

        T t1 = t.newInstance();

        return t1;
    }


    public Long getCounts(Collection<? extends Animal> collections){
        collections.forEach(System.out::println);
       /*  不能修改 是这个意思。 Collection<? extends Animal> collections 声明的对象不能被修改
        Animal animal=new Animal();
        collections.add(new Biology());*/
        return (long) collections.size();
    }

    public Long updateCollections(Collection<? super Animal> collections){
        collections.forEach(System.out::println);

        collections.add(new Dog());
        collections.add(new Cat());
        collections.add(new Animal());
        //collections.add(new Biology());//编译错误
        //collections.add(new Object());//编译错误
        collections.forEach(System.out::println);
        return (long)collections.size();
    }

}
