package com.zhang.myjava.interview;



class Biology {
	static {
		System.out.println("Biology的静态初始化块");
	}
	
	{
		System.out.println("Biology的普通初始化块");
	}
	
	public Biology() {
		System.out.println("Biology的无参构造函数");
	}
}

class Animal extends  Biology{
	static {
		System.out.println("Animal的静态初始化块");
	}
	
	{
		System.out.println("Animal的普通初始化块");
	}
	
	public Animal() {
		System.out.println("Animal的无参构造函数");
	}
	
	public Animal(String name) {
		this();
		System.out.println("Animal的带参构造函数:" + name);
	}
}

class Cat extends  Animal{
	static {
		System.out.println("Cat的静态初始化块");
	}
	
	{
		System.out.println("Cat的普通初始化块");
	}
	
	public Cat() {
		super("TOM");
		System.out.println("Cat的无参构造函数");
	}	
}

public class InstanceInitTest {		
	public static void main(String[] args) {
		new Cat();
		System.out.println("--------------");
		new Cat();
		
		Double d = 1.0;
		System.out.println(d);
		
		String str = "hello";
//		if(str instanceof Boolean ) {
//			System.out.println(str);
//		}
		
		Integer ina = 2;
		Integer inb = 2;
		
		System.out.println(ina==inb);
		
		Integer inc = 128;
		Integer ind = 128;
		
		System.out.println(inc==ind);
	}
}

