package com.zhang.myjava.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树
 * @author Administrator
 *
 */

class Node {
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}		
}

public class BinaryOrderTree {
	private Node root = null;
	
	public void buildTree(int[] array) {
		for(int i=0; i<array.length; i++) {
			insertData(array[i]);
		}
	}
	
	public void insertData(int data) {
		Node newNode = new Node(data);
		
		if(root == null) {			
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		while(true) {
			parent = current;
			if(data < current.data) {				
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
			}						
		}
	}
	
	//先序遍历
	public void preOrder() {
		this.preOrder(this.root);
	}
	
	//根-左-右
	public void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	
	//中序遍历
	public void midOrder() {
		this.midOrder(this.root);
	}
	
	//左-根-右
	public void midOrder(Node localRoot) {
		if(localRoot != null) {			
			midOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			midOrder(localRoot.right);
		}
	}
	
	//后序遍历
	public void postOrder() {
		this.postOrder(this.root);
	}
	
	//根-左-右
	public void postOrder(Node localRoot) {
		if(localRoot != null) {			
			postOrder(localRoot.left);			
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}
	
	//层序遍历
	public void layerOrder(){
		if(this.root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,8,7,4,9,3,1,6,7,5};
		BinaryOrderTree binaryOrderTree = new BinaryOrderTree();
		binaryOrderTree.buildTree(array);
		binaryOrderTree.preOrder();
		System.out.println();
		binaryOrderTree.midOrder();
		System.out.println();
		binaryOrderTree.postOrder();
		System.out.println();
		binaryOrderTree.layerOrder();	
	}

}
