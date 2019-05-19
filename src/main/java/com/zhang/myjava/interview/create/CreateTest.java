package com.zhang.myjava.interview.create;

public class CreateTest {
    public static String name = StaticTest.sayHello();
    private final Dog dog = new Dog();

    static {
        System.out.println("Dog init");
    }

    public static void info() {
        System.out.println("a dog");
    }

    public static void main(String[] args) {
        CreateTest.info();//首次主动使用进行初始化
        CreateTest.info();//不会再去初始化
    }
}
