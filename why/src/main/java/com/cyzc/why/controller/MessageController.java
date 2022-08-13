package com.cyzc.why.controller;

import com.cyzc.why.mq.ProducerService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/01 14:41]
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Resource
    private ProducerService ps ;

    @GetMapping("/send")
    public Object send(String message) {
        ps.send(message) ;
        return "send success" ;
    }
}
