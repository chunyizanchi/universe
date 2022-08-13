package com.cyzc.springboot.controller;

import com.cyzc.springboot.event.OrderEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/10 15:30]
 */
@RestController("/springEvent")
public class SpringEventController {

    @Autowired
    OrderEventPublisher orderEventPublisher;

    @RequestMapping(path = "event")
    public void event() {
        String s = orderEventPublisher.buyOrder("1");
    }

}
