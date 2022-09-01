package com.cyzc.dubbo.service;

import com.cyzc.dubbo.domian.OrderDomain;
import com.cyzc.dubbo.response.RpcResult;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/31 20:35]
 */
public interface OrderDubboService {

    RpcResult<OrderDomain> getOrder();
}
