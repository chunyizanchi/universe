package com.cyzc.springboot.conf;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/25 22:50]
 */
@Component
public class TerminateBean {

    Logger logger = LoggerFactory.getLogger(TerminateBean.class);

    @Qualifier("threadPoolExecutor1")
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @PreDestroy
    public void preDestroyThreadPool() throws InterruptedException {
        threadPoolExecutor.shutdownNow();
        threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("TerminateBean preDestroyThreadPool");

    }
}
