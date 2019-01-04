package com.zhang.myjava.algo.sort;

/**
 * 堆排序
 * @author Administrator
 *
 */

public class TestHeapSort {
	public static void main(String[] args) throws Exception {
		int[] a = {5, 7, 6, 1, 3, 0, 9, 2, 4, 8};
		
		heapSort(a);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
			
		}	
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void heapSort(int[] a) {
		if(a == null) return;
		int len = a.length;
		for(int i=0; i<a.length; i++) {
			buildMaxHeap(a, len-1-i);
			swap(a, 0, len-1-i);
		}
	}
	
	public static void buildMaxHeap(int[] a, int lastIndex) {
		for(int i=(lastIndex-1)/2; i>=0; i--) {
			int k = i;
			while(2*k+1 < lastIndex) {
				int childIndex = 2*k+1;
				if(a[childIndex] < a[childIndex+1]) {
					childIndex++;
				}
				
				if(a[k] < a[childIndex]) {
					swap(a, k, childIndex);
					k = childIndex;
				} else {
					break;
				}
			}
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}	
}
