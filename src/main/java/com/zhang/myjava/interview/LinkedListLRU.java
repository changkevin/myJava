package com.zhang.myjava.interview;
import java.util.*;
/**
 * 使用单链表实现的LRU
 */
public class LinkedListLRU {
    private static class Person{
        private String name;
        private String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String toString() {
            return "name:" + name + ",address:" + address;
        }

    }

    private List<Person> cache;
    private final static int MAX_CAPACITY = 4;

    public LinkedListLRU() {
        cache = new LinkedList<>();
    }


    public Person get(String name) {
        Person person = null;
        int index = 0;

        for(Person item : cache) {
            if(item.name.equals(name)) {
                System.out.println("get from cache,pos is:" + index);
                person = item;
                break;
            }
            index++;
        }

        if(person == null) {
            //模仿查找数据库过程
            System.out.println("get from db");
            person = new Person(name, "beijing");
            add(person);
        } else {
            //移动到头部
            if(index != 0) {
                cache.remove(index);
                cache.add(0, person);
            }
        }

        return person;
    }

    public void add(Person person) {
        System.out.println("add new item");
        int size = cache.size();
        if(size < MAX_CAPACITY) {
            cache.add(0, person);
            size++;
        } else {
            cache.remove(MAX_CAPACITY-1);
            cache.add(0, person);
        }
    }

    public void printAll() {
        for(Person item : cache) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Person person1 = new Person("tom", "shanghai");
        Person person2 = new Person("kate", "beijing");
        Person person3 = new Person("marry", "guangzhou");
        Person person4 = new Person("mike", "chongqing");
        Person person5 = new Person("david", "dalian");

        LinkedListLRU lru = new LinkedListLRU();
        lru.add(person1);
        lru.add(person2);
        lru.add(person3);
        lru.add(person4);
        lru.add(person5);
        //david-mike-marry-kate
        Person person = lru.get("david");
        System.out.println(person);
        lru.printAll();

        Person other = lru.get("joy");
        System.out.println(other);
        lru.printAll();


    }

}
