package com.zhang.myjava.algo.sort;


public class MergeSort {
	private static int[] aux;
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
		aux = new int[N];
		sort(a, 0, N-1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	private static void merge(int a[], int lo, int mid, int hi) {
		int i=lo;
		int j=mid+1;
		
		for(int k=lo; k<=hi; k++) {
			aux[k] = a[k];
		}
		
		for(int k=lo; k<=hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[i], aux[j])) a[k] = aux[i++];  //注意此处比较的是aux[]
			else a[k] = aux[j++];
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,0,1,7,5,4,6,8,9};
		MergeSort.sort(array);
		MergeSort.show(array);
	}	
}
