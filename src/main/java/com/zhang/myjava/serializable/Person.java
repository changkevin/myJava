package com.zhang.myjava.serializable;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 672345L;
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		System.out.println("有参数的构造函数");
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	private void writeObject(ObjectOutputStream out) 
			throws IOException {
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age+100);
	}
	
	private void readObject(ObjectInputStream in) 
			throws IOException,ClassNotFoundException {
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
}
