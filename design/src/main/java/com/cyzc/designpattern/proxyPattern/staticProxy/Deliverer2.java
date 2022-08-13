package com.cyzc.designpattern.proxyPattern.staticProxy;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/08/27 23:20]
 */
public class Deliverer2 implements OrderInterface {

    private OrderInterface source;

    public Deliverer2(OrderInterface source) {
        this.source = source;
    }


    @Override
    public String order(String foodName) {

        final String actual = source.order(foodName);

        System.out.println("已经接收到订单。。。食物是"+foodName);
        System.out.println("已经取餐，正在派送。。。"+foodName);

        return actual+"已经送达";
    }

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }
}
