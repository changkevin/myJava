package com.zhang.myjava.test;

/**
 * 
 * 不许用中间变量,把String ABCDE 倒转
 *
 */
public class ReverseStringWithoutTemp extends Object{
	
	public static void main(String[] args) {
		String abc = "ABCDE";
		for(int i=abc.toCharArray().length-1; i>=0; i--){
			abc += abc.toCharArray()[i];
		}
		System.out.println(abc);
		abc=abc.substring(abc.length()/2,abc.length());
		System.out.println(abc);
	}
}
