package com.zhang.myjava.algo.sort;

public class InsertionSort {
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
		for(int i=1; i<N; i++) {
			for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,0,1,7,5,4,6,8,9};
		InsertionSort.sort(array);
		InsertionSort.show(array);
	}	
}
