package com.cyzc.java.juc.completableFuture;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * <p> 美团对Cf 出现异常的封装
 *
 * @author Cyzc
 * @since [2022/11/22 21:54]
 */
public class ExceptionUtils {
    public static Throwable extractRealException(Throwable throwable) {
        //这里判断异常类型是否为CompletionException、ExecutionException，如果是则进行提取，否则直接返回。
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}
