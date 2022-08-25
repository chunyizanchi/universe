package com.cyzc.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/25 22:53]
 */
@RequestMapping("actuator")
public class ActuatorController {

    Logger logger = LoggerFactory.getLogger(ActuatorController.class);

    @RequestMapping("/shutdown")
    public void shutdown() {
        logger.info("actuator shutdown");
    }
}
