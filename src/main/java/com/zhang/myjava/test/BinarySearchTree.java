package com.zhang.myjava.test;

/**
 * 二叉查找树的实现
 *
 */
public class BinarySearchTree {
	private class Node {
		private int val;
		private Node left;
		private Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	private Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	public void put(int val) {
		root = put(root, val); 
	}
	
	private Node put(Node x, int val) {
		if(x == null) return new Node(val);
		if(val < x.val) {
			x.left = put(x.left, val);
		} else {
			x.right = put(x.right, val);
		}
		
		return x;
	}
	
	public void build(int[] data) {
		for(int i=0; i<data.length; i++){
			put(data[i]);
		}
	}
	
	//中序遍历
	public void inOrder() {
		this.inOrder(this.root);
	}
	
	private void inOrder(Node x) {
		if(x != null) {
			inOrder(x.left);
			System.out.print(x.val + " ");
			inOrder(x.right);
		}
	}
	
	public static void main(String args[]) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		tree.build(data);
		tree.inOrder();
	}
}
