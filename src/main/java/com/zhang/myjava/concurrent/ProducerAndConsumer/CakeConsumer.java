package com.zhang.myjava.concurrent.ProducerAndConsumer;

import java.util.Random;

public class CakeConsumer extends Thread{
    private int seed;
    private Table table;

    public CakeConsumer(String name, Table table, int seed) {
        super(name);
        this.seed = seed;
        this.table = table;
    }


    @Override
    public void run() {
        try {
            Random random = new Random(seed);
            while (true) {
                String cake = table.take();
                System.out.println(this.getName() + " eat " + cake);
                int time = random.nextInt(1000);
                Thread.sleep(time); //模拟吃蛋糕的制作时间
            }
        } catch(InterruptedException e){

        }
    }
}
