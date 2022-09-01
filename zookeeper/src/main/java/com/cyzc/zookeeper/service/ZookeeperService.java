package com.cyzc.zookeeper.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/01 21:35]
 */
public interface ZookeeperService {
    /**
     * 创建节点
     * @param path 节点路径
     * @param data 节点数据
     * @param perm 节点权限
     * @param nodeType 节点类型
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    String createNode(String path, String data, ArrayList<ACL> perm, CreateMode nodeType) throws KeeperException, InterruptedException;

    /**
     * 判断节点是否存在
     * @param path 节点路径
     * @param nodeWatch 是否复用zookeeper中默认的watch
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    Stat existNode(String path, boolean nodeWatch) throws KeeperException, InterruptedException;

    /**
     * 判断节点是否存在
     * @param path 节点路径
     * @param watcher 监听类型 创建/删除/更新
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    Stat existNode(String path, Watcher watcher) throws KeeperException, InterruptedException;

    /**
     * 修改节点
     * @param path 节点路径
     * @param data 节点数据
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    Stat updateNode(String path, String data) throws KeeperException, InterruptedException;

    /**
     * 删除节点
     * @param path 节点路径
     * @throws KeeperException
     * @throws InterruptedException
     */
    void deleteNode(String path) throws KeeperException, InterruptedException;

    /**
     * 获取节点数据
     * @param path 节点路径
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    String getNodeData(String path) throws KeeperException, InterruptedException;

    /**
     * 获取子节点
     * @param path 节点路径
     * @param nodeWatch 是否复用zookeeper中默认的watch
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    List<String> getChildrenNode(String path, boolean nodeWatch) throws KeeperException, InterruptedException;

    /**
     * 获取子节点
     * @param path 节点路径
     * @param watcher 监听类型 创建/删除/更新
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    List<String> getChildrenNode(String path, Watcher watcher) throws KeeperException, InterruptedException;
}
