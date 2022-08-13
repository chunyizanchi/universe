package com.cyzc.spring.proxy;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/31 07:59]
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public void showOrder() {
        System.out.println("OrderServiceImpl.showOrder");
    }
}
