package com.cyzc.java.generic.entity;

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

}
