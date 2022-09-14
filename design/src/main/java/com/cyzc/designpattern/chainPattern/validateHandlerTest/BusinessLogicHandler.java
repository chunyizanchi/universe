package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/14 10:18]
 */
public class BusinessLogicHandler extends Handler{

    @Override
    public void doHandler(Member member) {
        System.out.println("执行业务逻辑");
    }
}
