package com.cyzc.designpattern.chainPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 22:03]
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();

    protected abstract boolean doHandle();
}
