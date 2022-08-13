package com.cyzc.why.event;

import java.time.Clock;
import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/10 21:15]
 */
public class DrawPrizeEvent extends ApplicationEvent {

    private String prizeName;

    public DrawPrizeEvent(Object source) {
        super(source);
    }

    public DrawPrizeEvent(Object source, String prizeName) {
        super(source);
        this.prizeName = prizeName;
    }

    public String getPrizeName() {
        return prizeName;
    }
}
