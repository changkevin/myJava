package com.zhang.myjava.concurrent.ProducerAndConsumer;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        CakeProducer producer1 = new CakeProducer("Producer1", table, 10);
        CakeProducer producer2 = new CakeProducer("Producer2", table, 20);
        CakeProducer producer3 = new CakeProducer("Producer3", table, 30);

        CakeConsumer consumer1 = new CakeConsumer("Consumer1", table, 200);
        CakeConsumer consumer2 = new CakeConsumer("Consumer2", table, 300);
        CakeConsumer consumer3 = new CakeConsumer("Consumer3", table, 400);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
