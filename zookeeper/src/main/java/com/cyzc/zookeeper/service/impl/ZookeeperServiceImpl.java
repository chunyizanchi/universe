package com.cyzc.zookeeper.service.impl;

import com.cyzc.zookeeper.service.ZookeeperService;
import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 21:35]
 */
@Service
public class ZookeeperServiceImpl implements ZookeeperService {

    @Autowired
    private ZooKeeper zkClient;

    @Override
    public String createNode(String path, String data, ArrayList<ACL> perm, CreateMode nodeType)
            throws KeeperException, InterruptedException {
        String nodeStr = zkClient.create(path, data.getBytes(), perm, nodeType);
        return nodeStr;
    }

    @Override
    public Stat existNode(String path, boolean nodeWatch)
            throws KeeperException, InterruptedException {
        Stat exists = zkClient.exists(path, nodeWatch);
        return exists;
    }

    @Override
    public Stat existNode(String path, Watcher watcher)
            throws KeeperException, InterruptedException {
        Stat exists = zkClient.exists(path, watcher);
        return exists;
    }

    /**
     * 更新节点
     *
     * @param path 节点路径
     * @param data 节点数据 version 版本号，如果为-1，表示忽略版本检查
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Override
    public Stat updateNode(String path, String data) throws KeeperException, InterruptedException {
        Stat stat = zkClient.setData(path, data.getBytes(), 0);
        return stat;
    }

    @Override
    public void deleteNode(String path) throws KeeperException, InterruptedException {
        zkClient.delete(path, 0);
    }

    @Override
    public String getNodeData(String path) throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte[] data = zkClient.getData(path, true, stat);
        String dataStr = new String(data);
        return dataStr;
    }

    @Override
    public List<String> getChildrenNode(String path, boolean nodeWatch)
            throws KeeperException, InterruptedException {
        List<String> childrenList = zkClient.getChildren(path, nodeWatch);
        return childrenList;
    }

    @Override
    public List<String> getChildrenNode(String path, Watcher watcher)
            throws KeeperException, InterruptedException {
        List<String> childrenList = zkClient.getChildren(path, watcher);
        return childrenList;
    }
}
