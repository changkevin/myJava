package com.zhang.myjava.concurrent.PrintABC;

public class Printer2 extends Thread{
    private Counter counter;

    public Printer2(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while(true) {
                int  value = counter.get();
                if(value % 3 == 1 && value < 30) {
                    System.out.println(this.getName() + ":print B, value=" + value);
                    counter.add();
                }
                Thread.sleep(100);
            }
        } catch(InterruptedException e ) {
            System.out.println(e.getMessage());
        }

    }
}
