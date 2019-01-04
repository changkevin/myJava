package com.zhang.myjava.interview;

public class Quicksort {
    public static void sort(int[] array) {
        int N = array.length;
        sort(array, 0, N-1);
    }

    public static void sort(int[] array, int lo, int hi) {
        if(lo >= hi) return;

        int pivot = partition(array, lo, hi);
        sort(array, lo, pivot-1);
        sort(array, pivot+1, hi);

    }

    public static int partition(int[] array, int lo, int hi) {
        //int mid = lo + (hi-lo)/2;
        int v = array[lo];
        int lt = lo;
        int gt = hi+1;

        while(true) {
            while(array[++lt] < v) {
                if(lt==hi) break;
            }
            while(array[--gt] > v) {
                if(gt==lo) break;
            }
            if(lt >= gt) break;
            swap(array, lt, gt);
        }
        swap(array, lo, gt);

        return gt;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,0,1,7,5,4,6,8,9};
        Quicksort.sort(array);
        for(int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
