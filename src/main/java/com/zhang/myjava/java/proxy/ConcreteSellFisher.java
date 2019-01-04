package com.zhang.myjava.java.proxy;

public class ConcreteSellFisher implements ISellFisher{
    @Override
    public int sellFish() {
        System.out.println("my fish is delicious!!");
        return 10;
    }
}
