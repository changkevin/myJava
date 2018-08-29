package com.zhang.myjava.zookeeper;

import java.util.List;

import org.apache.zookeeper.KeeperException;

public class ListGroup extends ConnectionWatcher{
	public void list(String groupName) throws KeeperException,
    InterruptedException {
	  String path = "/" + groupName;
	
	  try {
	    //第二个参数若为true表示对这个父节点设置监视，应用程序可以接收组成员的加入，退出和这个父组znode被删除的有关通知
	    List<String> children = zk.getChildren(path, false);
	    if (children.isEmpty()) {
	      System.out.printf("No members in group %s\n", groupName);
	      System.exit(1);
	    }
	    for (String child : children) {
	      System.out.println(child);
	    }
	  } catch (KeeperException.NoNodeException e) {
	    System.out.printf("Group %s does not exist\n", groupName);
	    System.exit(1);
	  }
	}
	
	public static void main(String[] args) throws Exception {
	  ListGroup listGroup = new ListGroup();
	  listGroup.connect("127.0.0.1");
	  listGroup.list("zoo");
	  listGroup.close();
	}
}
