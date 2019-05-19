package com.zhang.myjava.geekbang;

/**
 * 测试缓存导致的可见性问题
 */

public class Test {
    private static long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }
    public static long calc() {
        try {
            final Test test = new Test();
            // 创建两个线程，执行 add() 操作
            Thread th1 = new Thread(()->{
                test.add10K();
            });
            Thread th2 = new Thread(()->{
                test.add10K();
            });
            // 启动两个线程
            th1.start();
            th2.start();
            // 等待两个线程执行结束
            th1.join();
            th2.join();
        } catch (InterruptedException e) {

        }
        return count;
    }

    public static void main(String[] args) {
        long result = Test.calc();
        System.out.println("result:" + result);
    }
}

