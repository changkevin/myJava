package com.zhang.myjava.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Person{
	String id;
	String name;
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return "id="+id+",name="+name;
	}
	
	public int hashCode(){
		return id.hashCode();
	}
	
	public boolean equals(Object obj){
		Person p=(Person)obj;
		if(p.id.equals(this.id)) {
			return true;
		} else {
			return false;
		}
	}
}
public class TestHashMap {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	public static void test1() {
		System.out.println("use person as key");
		HashMap<Person, String> hm = new HashMap<Person, String>();
		Map<Person, String> hm2 = new LinkedHashMap<Person, String>();
		Integer in = 1;

		Person p1 = new Person("1", "name1");
		Person p2 = new Person("1", "name1");
		hm.put(p1, "address1");
		hm.put(p2, "address2");
		
		Iterator iter = hm.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			Person key = (Person)entry.getKey();
			String val = (String)entry.getValue();
			System.out.println("key="+key+",value=" + val);
			
		}
	}
	
	public static void test2(){
		String remoteIp = "192.168.2.215";
        int hashCode = remoteIp.hashCode();
        int idx = hashCode % 12;
        System.out.println("hash code:" + idx);
	}
	
	public static void test3(){
		long rest = 35174605L;
		long ret = rest % 62L;
		long ret2 = rest - (rest/62) *62;
        System.out.println("ret:" + ret);
        System.out.println("ret2:" + ret2);
	}
	
	public static void test4(){
		int mid = (0+1)/2;
		 System.out.println("mid:" + mid);
	}
}
