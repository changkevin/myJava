package com.zhang.myjava.algo.sort;

/**
 * 插入排序算法
 * @author Administrator
 *
 */
public class TestInsertSort {
	public static void main(String[] args) {
		int[] array = {3, 6, 1, 8, 9, 0, 7, 5, 4, 2};
		int length = array.length;
		insertSort(array);
		for(int i=0; i<length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void insertSort(int[] array) {
		if(array == null) {
			return;
		}
		
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			int j = i;
			if(array[j-1] > temp) {
				while(j >= 1 && array[j-1] > temp) {
					array[j] = array[j-1];
					j--;					
				}
			}
			array[j] = temp;
		}
	}
}
