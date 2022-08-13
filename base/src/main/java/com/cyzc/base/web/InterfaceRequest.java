package com.cyzc.base.web;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 09:29]
 */
public interface InterfaceRequest {

    Long getTimestamp();

    String getApiVersion();

    String getRequestId();
}
