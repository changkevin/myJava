package com.zhang.myjava.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zck on 2018/8/31.
 */
public class JustTest {
    Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    List<Integer> list = new LinkedList<>();

}
