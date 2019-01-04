package com.zhang.myjava.algo.sort;

public class QuickSort {
	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,0,1,7,5,4,6,8,9};
		QuickSort.sort(array);
		for(int i = 0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void sort(int[] a) {
		int N = a.length;
		sort(a, 0, N-1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return; 
		int mid = partition(a, lo, hi);
		System.out.println("mid:"+mid);
		sort(a, lo, mid-1);
		sort(a, mid+1, hi);
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		int v = a[lo];
		
		while(true) {
			while(a[++i] < v ) {
				if(i==hi) break;
			}
			while(a[--j] > v ) {				
				//if(j==lo) break; //可以省略
			}
			if(i>=j) break;
			exch(a, i ,j);
		}
		exch(a, lo, j);
		return j;		
	}
	
	
}