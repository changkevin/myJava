package com.zhang.myjava.generics;

import java.util.ArrayList;
import java.util.Collection;

//泛型方法
public class GenericMethodTest {
	public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for(T o : a) {
			c.add(o);
		}
	}
	public static void main(String[] args) {
		String[] sa = {"hello", "java"};
		Collection<String> sc = new ArrayList<>();
		Collection<Object> oc = new ArrayList<>();
		fromArrayToCollection(sa, sc);
		sc.forEach(s->System.out.println(s));
		
		fromArrayToCollection(sa, oc);
		oc.forEach(s->System.out.println(s));
	}
}
