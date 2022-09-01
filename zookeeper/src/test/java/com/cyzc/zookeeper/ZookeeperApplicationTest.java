package com.cyzc.zookeeper;

import com.cyzc.zookeeper.service.ZookeeperService;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 21:44]
 */
@SpringBootTest
public class ZookeeperApplicationTest {
    @Autowired
    private ZookeeperService zookeeperService;

    @Test
    void contextLoads() throws KeeperException, InterruptedException {
        zookeeperService.createNode("/test", "test001", ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
}
