package com.cyzc.spring.proxy;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 08:00]
 */
public class OrderServiceProxy implements OrderService{

    private OrderServiceImpl orderService=new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("OrderServiceProxy.showOrder");
        orderService.showOrder();
    }
}
