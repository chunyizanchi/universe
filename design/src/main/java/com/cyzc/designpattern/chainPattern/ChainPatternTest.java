package com.cyzc.designpattern.chainPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 22:06]
 */
public class ChainPatternTest {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }

}
