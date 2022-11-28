package com.cyzc.java.juc.completableFuture;

import org.apache.thrift.TException;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/23 16:00]
 */
@FunctionalInterface
public interface ThriftAsyncCall {

    void  invoke() throws TException;
}
