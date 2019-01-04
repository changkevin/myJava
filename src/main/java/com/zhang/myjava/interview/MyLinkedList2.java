package com.zhang.myjava.interview;

/**
 * 带头结点的单链表实现
 */
public class MyLinkedList2 {
    private static class Node {
        private int data;
        private Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList2(){
        head = new Node();
        size = 0;
    }

    /**
     * 增：在链表尾部新增一个节点
     */
    public void add(int data) {
        Node newNode = new Node(data);

        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        size++;
    }

    /**
     * 删:删除最后一个节点
     */
    public void remove() {
        if(head.next == null) {
            return;
        }

        Node node = head;
        Node prev = null;

        while(node.next != null) {
            prev = node;
            node = node.next;
        }

        prev.next = null;
        size--;

    }

    /**
     * 改:修改指定位置的节点的值
     */

    public void set(int index, int data) {
        if(index< 0 || index > size-1) {
            return;
        }

        Node node = head;

        while(index >= 0) {
            node = node.next;
            index--;
        }

        node.data = data;
    }

    /**
     * 查:获取指定位置节点的值
     */
    public int get(int index){
        Node node = head;

        while(index >= 0) {
            node = node.next;
            index--;
        }

        return node.data;
    }

    /**
     * 获取链表大小
     */
    public int size() {
        return size;
    }

    /**
     * 打印
     */
    public void print(){
        Node node = head.next;
        while(node != null ) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        MyLinkedList2 list = new MyLinkedList2();
        list.add(1);
        list.add(20);
        list.add(13);
        list.add(4);
        System.out.println("size:" + list.size());
        list.print();

        list.set(0, 10);
        list.set(2, 30);
        list.set(3, 40);
        list.print();

        //查
        int data1 = list.get(0);
        System.out.println("data:" + data1);

        int data2 = list.get(2);
        System.out.println("data:" + data2);

        int data3 = list.get(3);
        System.out.println("data:" + data3);

        list.remove();
        list.print();

        list.remove();
        list.print();

        list.remove();
        list.print();

        list.remove();
        list.print();



    }
}
