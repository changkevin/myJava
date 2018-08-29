package com.zhang.myjava.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

public class SharedReentrantLockTest {
	public static final String ZOOKEEPERSTRING = "127.0.0.1:2181";
	public static final String PATH = "/work/da/datapull";
	public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZOOKEEPERSTRING, new ExponentialBackoffRetry(1000, 3));
        try {
            client.start();
            InitNodeLock initNodeLock = new InitNodeLock(client, PATH, args[0]);            
            initNodeLock.doWork();
            for(int i=0; i<10; i++) {
            		InitJobLock initJobLock = new InitJobLock(client, PATH + "/" + i, args[0]);            
                initJobLock.doWork();
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(client);
        }
        
    }
}
