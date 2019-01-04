package com.zhang.myjava.java.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) {
		try{
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("object.txt"));
			Person person = (Person)ois.readObject();
			System.out.println("name:" +person.getName() + ",age:" + person.getAge());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
