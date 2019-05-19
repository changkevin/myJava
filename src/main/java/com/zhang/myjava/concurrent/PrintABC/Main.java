package com.zhang.myjava.concurrent.PrintABC;

/**
 * 三个线程交替打印A、B、C,循环打印10次
 */
public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        Printer1 printer1 = new Printer1("Printer1", counter);
        Printer2 printer2 = new Printer2("Printer2", counter);
        Printer3 printer3 = new Printer3("Printer3", counter);

        printer1.start();
        printer2.start();
        printer3.start();
    }
}
