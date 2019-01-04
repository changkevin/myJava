package com.zhang.myjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {
    public static void main(String[] args) {
        ISellFisher sell = new ConcreteSellFisher();
        InvocationHandler handler = new ProxySellFisher(sell);
        Object obj = Proxy.newProxyInstance(sell.getClass().getClassLoader(), sell.getClass().getInterfaces(), handler);
        int price = ((ISellFisher)obj).sellFish();
        System.out.println("price:" + price);
    }
}
