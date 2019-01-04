package com.zhang.myjava.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySellFisher implements InvocationHandler {
    private ISellFisher sellFisher;

    public ProxySellFisher(ISellFisher sellFisher) {
        this.sellFisher = sellFisher;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass());
        System.out.println("the fish price higher");
        return (Integer)method.invoke(sellFisher, args)+10;
    }
}
