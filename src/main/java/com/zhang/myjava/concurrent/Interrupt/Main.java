package com.zhang.myjava.concurrent.Interrupt;

/**
 * 目标：当前线程被中断之后，退出while（true）
 * MyThread：可能出现无限循环
 * MyThread2：可正常实现目标
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        //MyThread thread=new MyThread();
        MyThread2 thread=new MyThread2();
        thread.start();
        thread.interrupt();
        Thread.currentThread().sleep(1000);
    }
}
