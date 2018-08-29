package com.zhang.myjava.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class CreateGroup implements Watcher {
	private static final int SESSION_TIMEOUT = 5000;

	  //ZooKeeper类是客户端API的主要类，用于维护客户端和ZooKeeper服务之间的连接
	  private ZooKeeper zk;
	  //锁存器(latch)此计数器为1，表示在释放所有等待线程之前需要发生的事件数，
	  private CountDownLatch connectedSignal = new CountDownLatch(1);

	  public void connect(String hosts) throws IOException, InterruptedException {
	    //参数this表示一个Watcher对象接收来自于Zookeeper的回调，以获得各种事件的通知，在此表示CreateGroup对象
	    zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
	    connectedSignal.await();
	  }

	  public void process(WatchedEvent event) { // Watcher interface
	    if (event.getState() == KeeperState.SyncConnected) {
	      //在调用这个方法表示计数器递减1，若计数器的值变为0，则await()方法返回
	      connectedSignal.countDown();
	    }
	  }

	  public void create(String groupName) throws KeeperException,
	      InterruptedException {
	    String path = "/" + groupName;
	    String createdPath = zk.create(path, null/*data*/, Ids.OPEN_ACL_UNSAFE,
	        CreateMode.PERSISTENT);// 持久化的 znode
	    System.out.println("Created " + createdPath);
	  }

	  public void close() throws InterruptedException {
	    zk.close();
	  }

	  public static void main(String[] args) throws Exception {
	    CreateGroup createGroup = new CreateGroup();
	    createGroup.connect("127.0.0.1");
	    createGroup.create("dashboard");
	    createGroup.close();
	  }
}
