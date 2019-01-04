package com.zhang.myjava.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SlideWindow {

    private Integer[] array;
    private int windowSize;

    public SlideWindow(Integer[] array, int windowSize) {
        this.array = array;
        this.windowSize = windowSize;
    }

    public List<Integer> getMax() {

        List<Integer> result = new ArrayList<>();

        //构建一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(windowSize, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });

        for(int i=0; i<array.length; i++) {
            if(i < windowSize-1) {  //如果达不到窗口的大小，直接添加元素
                maxHeap.add(array[i]);
            } else if(i == windowSize-1) { //如果等于窗口的大小，查找当前的最大值（即堆顶元素）
                System.out.println("i=" + i + "," + maxHeap.peek());
                result.add(maxHeap.peek());
            } else { //如果大于窗口的大小，先删除最早加入的元素，再加入新的元素，查找当前的最大值（即堆顶元素）
                maxHeap.remove(array[i - windowSize]);
                maxHeap.add(array[i]);
                System.out.println("i=" + i + "," + maxHeap.peek());
                result.add(maxHeap.peek());
            }
        }

        return result;
    }


    public static void main(String[] args) {
        final int WINDOW_SIZE = 3;
        Integer[] array = {12,3,5,10,7,8};

        SlideWindow sw = new SlideWindow(array, WINDOW_SIZE);
        List<Integer> result = sw.getMax();
        result.forEach(System.out::println);
    }
}
