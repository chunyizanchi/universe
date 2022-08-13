package com.cyzc.designpattern.chainPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 22:04]
 */
public class HandlerA extends Handler {

    @Override
    public void handle() {
        boolean handled = false;

        if (!handled && successor != null) {
            successor.handle();
        }

    }

    @Override
    protected boolean doHandle() {
        return false;
    }
}
