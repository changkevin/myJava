package com.zhang.myjava.sort;

public class BaseSort {
	
	public static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
