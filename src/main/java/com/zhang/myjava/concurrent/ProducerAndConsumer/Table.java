package com.zhang.myjava.concurrent.ProducerAndConsumer;

public class Table {
    private String[] cakes;
    private int MAX_CAPACITY;
    private int head;
    private int tail;
    private int count;


    public Table(int capacity) {
        this.tail = 0;
        this.head = 0;
        this.count = 0;
        this.MAX_CAPACITY = capacity;
        this.cakes = new String[capacity];
    }

    public synchronized void put(String cake) {
        try {
            while (count >= MAX_CAPACITY) {
                this.wait();
            }
            cakes[head] = cake;
            head = (head+1) % MAX_CAPACITY;
            count++;
            this.notifyAll();
        }catch (InterruptedException e) {

        }
    }

    public synchronized String take(){
        String cake = "";
        try {
            while (count < 1) {
                this.wait();
            }
            cake = cakes[tail];
            tail = (tail+1) % MAX_CAPACITY;
            count--;
            this.notifyAll();
        }catch (InterruptedException e) {

        }
        return cake;
    }
}
