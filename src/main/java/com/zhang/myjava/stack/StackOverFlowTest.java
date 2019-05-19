package com.zhang.myjava.stack;

/**
 * 演示通过递归调用方法,不停的产生栈帧,一直把栈空间堆满,直到抛出StackOverflowError
 * 设置-Xss160k (最小要求160k)
 */
public class StackOverFlowTest {
    private long depth = 0;

    private void stackOverFlowMethod() {
        System.out.println("depth:" + ++depth);
        stackOverFlowMethod();
    }

    public static void main(String[] args) {
        StackOverFlowTest stackTest = new StackOverFlowTest();
        stackTest.stackOverFlowMethod();
    }
}
