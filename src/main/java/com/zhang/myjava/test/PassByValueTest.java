package com.zhang.myjava.test;

/**
 * 
 * 参数值传递测试
 *
 */
public class PassByValueTest {
	String str = new String("good"); 
	char[] ch = {'a','b','c'};
	
	public static void main(String[] args) {
		PassByValueTest ex = new PassByValueTest();//位于main栈区
		System.out.println(ex.str);
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str+" and ");
		System.out.print(ex.ch);
	}
	
	public void change(String str, char[] ch) {
		System.out.println(str);
		str = "test ok";  //位于change栈区
		ch[0] = 'g';
	}
}
