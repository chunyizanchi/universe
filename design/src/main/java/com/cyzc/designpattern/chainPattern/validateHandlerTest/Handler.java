package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p> Handler 抽象类。 build创建Handler对象
 *
 * @author Cyzc
 * @since [2022/09/14 09:59]
 */
public abstract class Handler<T> {

    protected Handler next;

    private void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T> {

        private Handler head;
        private Handler tail;


        public Builder<T> addHandler(Handler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }


    }

}
