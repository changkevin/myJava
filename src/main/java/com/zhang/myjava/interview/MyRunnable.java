package com.zhang.myjava.interview;

/**
 * 分析这段程序的运行结果
 * 实际运行结果可能出现部分值没有被输出，部分值被重复输出
 * i=Integer.valueOf(i.intValue()+1);
 * Integer.valueOf每次都是新对象
 */
public class MyRunnable implements Runnable{
    public static Integer i = new Integer(0);
    @Override
    public void run() {
        while(true) {
            synchronized(i) {
            //synchronized(MyRunnable.class) {
                if(i<100) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + ",i=" + i);
                } else {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}
