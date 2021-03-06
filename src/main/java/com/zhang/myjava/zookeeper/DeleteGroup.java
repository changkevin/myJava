package com.zhang.myjava.zookeeper;

import java.util.List;

import org.apache.zookeeper.KeeperException;

public class DeleteGroup extends ConnectionWatcher{
	public void delete(String groupName) throws KeeperException,
    InterruptedException {
	  String path = "/" + groupName;
	
	  try {
	    List<String> children = zk.getChildren(path, false);
	    for (String child : children) {
	      zk.delete(path + "/" + child, -1);//-1表示绕过版本检测机制，不管znode版本是什么直接将其删除
	    }
	    zk.delete(path, -1);
	  } catch (KeeperException.NoNodeException e) {
	    System.out.printf("Group %s does not exist\n", groupName);
	    System.exit(1);
	  }
	}
	
	public static void main(String[] args) throws Exception {
	  DeleteGroup deleteGroup = new DeleteGroup();
	  deleteGroup.connect("127.0.0.1");
	  deleteGroup.delete("zoo");
	  deleteGroup.close();
	}
}
