package com.zhang.myjava.algo.sort;

public class ShellSort {
	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(int a, int b) {
		if(a<b) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void show(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void sort(int[] a) {
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h+1;		
		while(h >= 1) {   //h>=1
			//System.out.println("h:" + h);
			for(int i=h; i<N; i++) { //i=h
				//System.out.println("i:" + i);
				for(int j=i; j>=h && less(a[j], a[j-h]); j-=h) {   //j=i
					//System.out.println("j:" + j);
					exch(a, j, j-h);
				}
			}
			//show(a);
			h/=3;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,0,1,2,9,4,6,8,5};
		ShellSort.sort(array);
		ShellSort.show(array);
	}

	public static class BaseSort {

		public static void exch(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

	}
}
