package com.zhang.myjava.sort;


/**
 * 选择排序算法
 * @author Administrator
 *
 */
public class TestSelectSort {
	public static void main(String[] args) {
		int[] array = {3, 6, 1, 8, 9, 0, 7, 5, 4, 2};
		int length = array.length;
		selectSort(array);
		for(int i=0; i<length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void selectSort(int[] array) {
		int minIndex = 0;
		if(array == null) {return;}
		for(int i=0; i<array.length; i++) {
			int min = array[i];
			//查找
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < min) {
					min = array[j];
					minIndex = j;
				}
			}
			
			//交换
			if(minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;								
			}			
		}		
	}
}
