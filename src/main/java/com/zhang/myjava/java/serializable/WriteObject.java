package com.zhang.myjava.java.serializable;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		try{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("object.txt"));
			Person person = new Person("孙悟空", 500);
			oos.writeObject(person);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
