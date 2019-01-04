package com.zhang.myjava.algo.sort;

/**
 * 希尔排序
 * @author Administrator
 *
 */

public class TestShellSort {
	public static void main(String[] args) throws Exception {
		int[] a = {5, 7, 6, 1, 3, 0, 9, 2, 4, 8};
		
		shellSort(a);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
			
		}		
	}
	
	public static void shellSort(int[] array) {
		if(array == null) return;
		
		int length = array.length;
		int i,j;
		int temp;
		
		for(int increment=length/2; increment>0; increment/=2) {
			for(i=increment; i<length; i++) {
				temp = array[i];
				for(j=i-increment; j>=0; j-=increment) {
					if(temp < array[j]) {
						array[j+increment] = array[j];
					} else {
						break;
					}
				}
				array[j+increment] = temp;
			}
		}		
	}
}
