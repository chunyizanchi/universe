package com.cyzc.designpattern.factoryPattern;

/**
 * @author: Cyzc
 * @description: 工厂模式
 * @create: 2020-12-26
 */
public class FactoryPattern {



}
class SimpleFactory{

    public static Product createProduct(String type){
        if ("A".equals(type)){
            return new ProductA();
        }else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        //System.out.println(product);
        product.print();
    }

}
abstract class Product{
    public abstract void print();
}
class ProductA extends Product{

    @Override
    public void print() {

    }
}
class ProductB extends Product{

    @Override
    public void print() {

    }
}