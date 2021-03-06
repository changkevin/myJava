package com.zhang.myjava.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class JoinGroup extends ConnectionWatcher{
	public void join(String groupName, String memberName) throws KeeperException,
    InterruptedException {
	  String path = "/" + groupName + "/" + memberName;
	  String createdPath = zk.create(path, null/*data*/, Ids.OPEN_ACL_UNSAFE,
	    CreateMode.EPHEMERAL);
	  System.out.println("Created " + createdPath);
	}
	
	public static void main(String[] args) throws Exception {
	  JoinGroup joinGroup = new JoinGroup();
	  joinGroup.connect("127.0.0.1");
	  joinGroup.join("zoo", args[0]);
	
	  // stay alive until process is killed or thread is interrupted
	  Thread.sleep(Long.MAX_VALUE);
	}
}
