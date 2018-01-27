package com.zhang.myjava.sort;


/**
 * 归并排序算法
 * @author Administrator
 *
 */

public class TestMergeSort {
	public static void main(String[] args) {
		int[] array = {3, 6, 1, 8, 9, 0, 7, 5, 4, 2};
		int length = array.length;
		mergeSort(array, 0, length-1);
		for(int i=0; i<length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void mergeSort(int[] array, int low, int high) {
		if(array == null) return;
		
		int mid = (low + high) / 2;
		if(low < high) {		
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}
	
	public static void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i= low; //左指针
		int j= mid+1; //右指针
		int k=0;
		
		//把较小的数先移到数组中
		while(i <= mid && j <= high) {
			if(array[i] < array[j]) {
				temp[k++] = array[i++];
			} else{
				temp[k++] = array[j++];
			}
		}
		
		//把左边剩余的数移到数组中
		while(i <= mid) {
			temp[k++] = array[i++];
		}
		
		//把右边剩余的数移到数组中
		while(j <= high) {
			temp[k++] = array[j++];
		}
		
		//把新数组中的数覆盖array数组
		for(int m=0; m<temp.length; m++) {
			array[m+low] = temp[m];
		}					
	}
}


