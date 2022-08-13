package com.cyzc.springboot.event;

import java.time.Clock;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * <p> 创建事件类
 *
 * @author Cyzc
 * @since [2022/06/28 22:40]
 */
@Getter
@Setter
@ToString
public class OrderProductEvent extends ApplicationEvent {

    private String orderId;

    public OrderProductEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }

}
