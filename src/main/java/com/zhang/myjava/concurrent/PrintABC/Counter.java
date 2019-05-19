package com.zhang.myjava.concurrent.PrintABC;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    public Counter(int value) {
        this.value = value;
    }

    public void add() {
        lock.lock();
        try {
            value = get()+1;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        lock.lock();
        try {
            return this.value;
        } finally {
            lock.unlock();
        }
    }
}
