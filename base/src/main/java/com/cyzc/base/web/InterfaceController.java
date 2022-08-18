package com.cyzc.base.web;

import com.cyzc.base.function.Consumer;
import com.cyzc.base.function.Function;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 21:35]
 */
public interface InterfaceController {

    default <T extends InterfaceRequest, R> Response<R> tryFunction(T t, Function<R> function) {
        try {
            return Response.result(t, function.run());
        } catch (Throwable var4) {
            return this.handleThrowable(var4, t);
        }
    }

    default <T extends InterfaceRequest> Response<Void> tryConsumer(T t, Consumer consumer) {
        try {
            consumer.run();
            return Response.success(t);
        } catch (Throwable var4) {
            return this.handleThrowable(var4, t);
        }
    }

    default <T> Response<T> handleThrowable(Throwable throwable, InterfaceRequest request) {
        //todo 打日志

        return Response.failure(request, throwable.getMessage());
    }

}
