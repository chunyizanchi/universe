package com.cyzc.zookeeper.config;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 21:25]
 */
@Configuration
public class ZookeeperConfig {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);
    //zookeeper连接信息
    @Value("${zookeeper.connect.address}")
    private String connectStr;
    //session超时时间(毫秒)
    @Value("${zookeeper.connect.time-out}")
    private int timeOut;
    private CountDownLatch connectLatch = new CountDownLatch(1);

    /**
     * 初始化zookeeper连接
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Bean
    public ZooKeeper getZkClient() throws IOException, InterruptedException {
        ZooKeeper zkClient = new ZooKeeper(connectStr, timeOut, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    connectLatch.countDown();
                }
            }
        });
        connectLatch.await();
        logger.info("getZkClint success");
        return zkClient;
    }

}
