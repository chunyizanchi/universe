package com.cyzc.designpattern.chainPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/26 22:06]
 */
public class HandlerChain {
    private Handler head=null;
    private Handler tail=null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);
        if (head==null){
            head=handler;
            tail=handler;
            return;
        }

        tail.setSuccessor(handler);
        tail=handler;
    }

    public void handle(){
        if (head!=null){
            head.handle();
        }
    }

}
