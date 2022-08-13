package com.cyzc.designpattern.chainPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 22:05]
 */
public class HandlerB extends Handler {

    @Override
    public void handle() {
        boolean handled = false;

        if (!handled && successor != null) {
            successor.handle();
        }
    }

    @Override
    protected boolean doHandle() {
        boolean handled = false;
        //...
        return handled;
    }
}
