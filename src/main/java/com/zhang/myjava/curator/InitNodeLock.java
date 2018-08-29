package com.zhang.myjava.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

public class InitNodeLock {
	private final InterProcessMutex lock;
    private final String clientName;
    private final String lockPath;
    
    public InitNodeLock(CuratorFramework client, String lockPath, String clientName) {
        this.clientName = clientName;
        this.lockPath = lockPath;
        lock = new InterProcessMutex(client, lockPath);
    }
    
    public void doWork() throws Exception {       
        try {
        		Thread.sleep((new java.util.Random().nextInt(2000)));
            lock.acquire();  
            if(lock.isAcquiredInThisProcess()) {
            		System.out.println(clientName + " has the lock, path=" + lockPath);
            } else {
            		throw new IllegalStateException(clientName + " could not acquire the lock");
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        		System.out.println(clientName + " releasing the lock");
            lock.release();
        }
    }
}
