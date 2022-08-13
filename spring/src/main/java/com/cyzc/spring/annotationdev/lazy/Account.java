package com.cyzc.spring.annotationdev.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/02 17:33]
 */
@Component
@Lazy
public class Account {

    public Account() {
        System.out.println("Account constructor");
    }
}
