package com.zhang.myjava.generics;

class MyClass<E> {
	public <E> MyClass(E e) {
		System.out.println("参数的值为：" + e);
	}
}

class OtherClass<E> {
	public <T> OtherClass(T t) {
		System.out.println("参数的值为：" + t);
	}
}

public class GenericDiamondTest {
	public static void main(String[] args) {
		MyClass<String> mc = new  MyClass<String>("hello");
		MyClass<String> mc2 = new  <Integer> MyClass<String>(5);
		OtherClass<String> oc = new OtherClass<>(5);
	}
}
