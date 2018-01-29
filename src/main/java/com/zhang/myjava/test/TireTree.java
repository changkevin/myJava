package com.zhang.myjava.test;

import java.util.Arrays;
import java.util.Vector;

/**
 * 
 * 26向单词查找树
 *
 */
public class TireTree {
	private class Node {
		private Vector<String> val = new Vector<String>();
		private Node[] next = new Node[26];
	}
	
	private void InsertNode(Node root, String str) {
		if(str.length()==0) return;
		
		if(root == null) {
			root = new Node();
		}
		
		int i = 0;
		char[] array = str.toCharArray();
		Arrays.sort(array);
		Node x = root;
		while(i < str.length()) {
			if(x.next[array[i]-'a'] == null) {
				Node n = new Node();
				x.next[array[i]-'a'] = n;
			}
			x = x.next[array[i]-'a'];
			i++;
		}
		
		x.val.add(str);		
	}
	
	public void findBrother() {
		Node root = new Node();
		InsertNode(root, "hehao");
		InsertNode(root, "ehaoh");
	}
	public static void main(String[] args) {
		TireTree tireTree = new TireTree();
		tireTree.findBrother();
	}
}
