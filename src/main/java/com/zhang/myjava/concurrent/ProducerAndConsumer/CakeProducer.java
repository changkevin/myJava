package com.zhang.myjava.concurrent.ProducerAndConsumer;

import java.util.Random;

public class CakeProducer extends Thread{
    private int seed;
    private Table table;
    private static int cakeNum = 1;


    public CakeProducer(String name, Table table, int seed) {
        super(name);
        this.seed = seed;
        this.table = table;
    }


    @Override
    public void run() {
        try {
            Random random = new Random(seed);
            while (true) {
                int time = random.nextInt(1000);
                Thread.sleep(time); //模拟蛋糕的制作时间
                String cake = "cake" + cakeNum;
                table.put(cake);
                System.out.println(this.getName() + " make " + cake);
                cakeNum++;
            }
        } catch(InterruptedException e){

        }
    }
}
