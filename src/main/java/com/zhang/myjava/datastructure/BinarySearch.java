package com.zhang.myjava.datastructure;

/**
 * 二分查找法
 * @author Administrator
 *
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = {1,4,17,34,54,71,101,582};
		int index = binarySearch(a, 582);
		System.out.println("循环查找:" + index);
		
		index = binarySearch(a, 582, 0, a.length-1);
		System.out.println("递归查找:" + index);
	}
	
	//循环实现
	public static int binarySearch(int[] array, int x) {
		if(array == null || x<array[0] || x>array[array.length-1]) return -1;
		
		int length = array.length;
		int mid = length / 2;
		int low = 0;
		int high = length -1;
		
		while(low <= high) {
			mid = (high + low) / 2;
			if(array[mid] < x) {
				low = mid +1;
			} else if(array[mid] > x) {
				high = mid-1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
	//递归实现
	public static int binarySearch(int[] array, int x, int low, int high) {
		if(array == null || low>high || x<array[0] || x>array[array.length-1]) {
			return -1;
		}
		
		int mid = (high + low) / 2;
		if(array[mid] < x) {
			return binarySearch(array, x, mid+1, high);
		} else if(array[mid] > x) {
			return binarySearch(array, x, 0, mid-1);
		} else {
			return mid;
		}
		
	}
}
