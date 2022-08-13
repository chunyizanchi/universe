package com.cyzc.designpattern.adapterPattern;

/**
 * <p>适配方法，用于组合ITarget/Adaptee
 *
 * @author Cyzc
 * @since [2022/03/11 10:52]
 */
public class Adapter extends Adaptee implements ITarget{
    @Override
    public void f1() {
        super.funcA();
        System.out.println("funcA 进行适配处理");
    }

    @Override
    public void f2() {
        super.funcB();
        System.out.println("funcB 进行适配处理");
    }

    @Override
    public void f3() {
        super.funcC();
        System.out.println("funcC 进行适配处理");
    }

    @Override
    public void f4() {
        super.funcD();
        super.funcA();
        System.out.println("funcD funcA 进行适配处理");
    }
}
