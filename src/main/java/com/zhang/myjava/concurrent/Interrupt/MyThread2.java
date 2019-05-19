package com.zhang.myjava.concurrent.Interrupt;

public class MyThread2 extends Thread {
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
                Thread.currentThread().interrupt();
            }
        }
    }
}
