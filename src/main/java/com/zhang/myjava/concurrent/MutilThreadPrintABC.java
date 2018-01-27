package com.zhang.myjava.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutilThreadPrintABC {
	public static int cnt = 0;
	public static final int COUNT = 30;
	
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		Thread A = new Thread(new Runnable(){
			public void run() {
				while(cnt<=COUNT) {
					lock.lock();
					if(cnt%3==0) {
						System.out.print("A");
						cnt++;
					}
					lock.unlock();
				}
			}
		});
		
		Thread B = new Thread(new Runnable(){
			public void run() {
				while(cnt<=COUNT) {
					lock.lock();
					if(cnt%3==1) {
						System.out.print("B");
						cnt++;
					}
					lock.unlock();
				}
			}
		});
		
		Thread C = new Thread(new Runnable(){
			public void run() {
				while(cnt<=COUNT) {
					lock.lock();
					if(cnt%3==2) {
						System.out.print("C ");
						cnt++;
					}
					lock.unlock();
				}
			}
		});
		
		A.start();
		B.start();
		C.start();
	}

}
