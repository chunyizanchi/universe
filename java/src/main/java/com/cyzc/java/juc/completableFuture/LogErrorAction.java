package com.cyzc.java.juc.completableFuture;

import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/23 16:04]
 */
@Slf4j
public class LogErrorAction<R> extends AbstractLogAction<R> implements BiConsumer<R, Throwable> {
    public LogErrorAction(String methodName, Object... args) {
        super(methodName, args);
    }
    @Override
    public void accept(R result, Throwable throwable) {
        logResult(result, throwable);
    }
}
