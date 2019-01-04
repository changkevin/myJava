package com.zhang.myjava.interview;

public class FindRepeatNumber {
	int n=0;
	public int count(String s){
		if(s.contains("a")){
			n++;
			String temp=s.substring(s.indexOf("a")+1);
			count(temp);
		}
		return n;
	}
	public static void main(String[] args) {
		System.out.println(new FindRepeatNumber().count("sdfasdfaafa"));
	}
}
