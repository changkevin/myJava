package com.zhang.myjava.sort;

public class HeapSort {
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
		int N = a.length-1; //注意此处要减1
		for(int k=N/2; k>=1; k--) {
			sink(a, k, N);
		}
		while(N>1) { //注意此处条件
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static void sink(int[] a, int k, int N) {		
		while(2*k<=N) { //注意此处条件
			int j = 2*k;
			if(j<N && less(a[j], a[j+1])) { //注意此处条件
				j++;
			}
			if(!less(a[k], a[j])) break;
			exch(a, k, j);
			k = j;
		}		
	}
	
	public static void main(String[] args) {
		int[] A = {0,2,3,0,1,7,5,4,6,8,9}; //不使用第0个元素
		
		HeapSort.sort(A);
		HeapSort.show(A);
	}	
}
