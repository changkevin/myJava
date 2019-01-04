package com.zhang.myjava.algo.sort;


public class SelectionSort {
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
		for(int i=0; i<N; i++) {
			int min = i;  //关键地方在这里
			for(int j=i+1; j<N; j++) {
				if(less(a[j], a[min])) {
					min = j;					
				}
			}
			exch(a, i, min);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,0,1,7,5,4,6,8,9};
		SelectionSort.sort(array);
		SelectionSort.show(array);
	}		
}

