package com.zhang.myjava.concurrent;

class Sequence{
	private int value;
//	public synchronized int getNext(){
//		return value++;
//	}
	
	public int getNext(){
		return value++;
	}
}


public class SequenceTest {
	public static void main(String[] args) {
		
		final Sequence seq = new Sequence();
		Thread A = new Thread(new Runnable(){
			public void run() {
				for(int i=0; i<100; i++) {
					int val = seq.getNext();
					System.out.println("A: " + val);
				}
			}
		});
		
		Thread B = new Thread(new Runnable(){
			public void run() {
				for(int i=0; i<100; i++) {
					int val = seq.getNext();
					System.out.println("B: " + val);
				}
			}
		});
		
		Thread C = new Thread(new Runnable(){
			public void run() {
				for(int i=0; i<100; i++) {
					int val = seq.getNext();
					System.out.println("C: " + val);
				}
			}
		});
		
		A.start();
		B.start();
		C.start();
	}


}
