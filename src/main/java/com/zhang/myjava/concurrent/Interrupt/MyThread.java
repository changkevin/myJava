package com.zhang.myjava.concurrent.Interrupt;

/**
 * 可能出现无限循环，线程在sleep期间被打断了，抛出一个InterruptedException异常，
 * try catch捕捉此异常，应该重置一下中断标示，因为抛出异常后，中断标示会自动清除掉！
 */
public class MyThread extends Thread {
    @Override
    public  void run() {
        Thread th = Thread.currentThread();
        while(true) {
            if(th.isInterrupted()) {
                System.out.println("MyThread isInterrupted:" + th.isInterrupted());
                break;
            }
            // 省略业务代码无数
            System.out.println("MyThread is running");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("====InterruptedException====");
                e.printStackTrace();
            }
        }
    }
}
