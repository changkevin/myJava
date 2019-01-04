package com.zhang.myjava.algo.sort;

/**
 * 快速排序算法
 * 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
 * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
 * 为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。
 * 快速排序是一个不稳定的排序方法。
 * @author Administrator
 *
 */

public class TestQuickSort extends ShellSort.BaseSort {
	public static void main(String[] args) {
		int[] a = {5, 7, 6, 1, 3, 0, 9, 2, 4, 8};
		
		quickSort(a);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
			
		}
	}
	
	public static void quickSort(int[] array) {
		if(array == null) return;
		sort(array, 0, array.length-1);
	}
	
	public static void sort(int[] array, int low, int high) {		
		int mid;
		if(low < high) {
			//mid = getMiddle(array, low, high);
			mid = patition(array, low, high);
			sort(array, low, mid-1);
			sort(array, mid+1, high);
		}						
	}
	
	/**
     * 查找出中轴（默认是最低位low）的在array数组排序后所在位置
     * 
     * @param array 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
	public static int getMiddle(int[] array, int low, int high) {
		int key = array[low];

		while(low < high) {
			while(low < high && array[high] >= key) {
				high--;
			}
			array[low] = array[high];

			
			while(low < high && array[low] <= key) {
				low++;				
			}
			array[high] = array[low];

		}
		
		array[low] = key;
		return low;
	}
	
	private static int patition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		
		int v = a[lo];
		
		while(true) {
			while(a[++i] < v) {
				if(i==hi) break;
			}
			
			while(a[--j] > v) {
				if(j==lo) break;
			}
			if(i>=j) break;	
			exch(a, i, j);											
		}
		exch(a, lo, j);
		
		return j;
	}
}
