package com.zhang.myjava.interview;

/**
 * 无头结点的单链表实现
 */
public class MyLinkedList {
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

    private  Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 增:在链表尾部新增一个节点
     */
    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            Node node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        size++;

    }

    /**
     * 删:删除最后一个节点
     */
    public void remove() {
        if(head == null) {
            return;
        }

        Node node = head;
        Node prev = null;
        if(node.next == null) {
            head = null;
            size = 0;
        } else {
            while(node.next != null) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
            size--;
        }

    }

    /**
     * 改:修改指定位置的节点的值
     */
    public void set(int index, int value) {
        if(index < 0 || index > size-1) {
            return;
        }

        Node node = head;
        if(index == 0) {
            node.data = value;
        } else {
            while (index > 0) {
                node = node.next;
                index--;
            }
            node.data = value;
        }
    }


    /**
     * 查:获取指定位置节点的值
     */
    public int get(int index) {
//        if (index < 0 || index > size - 1) {
//            throw new Exception("bad index");
//        }

        Node node = head;

        if(index == 0) {
            return node.data;
        } else {
            while (index > 0) {
                node = node.next;
                index--;
            }
            return node.data;
        }
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
    public void print() {
        Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    /**
     * 反转单链表
     */
    public void reverse() {
        Node prev = null;
        Node after = null;
        Node cur = head;

        while(cur != null) {
            after = cur.next;
            cur.next = prev;
            prev = cur;
            cur = after;
        }
        head = prev;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        //增
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);

        System.out.println("size:" + list.size());
        list.print();

        //反转
        list.reverse();
        list.print();

        //改
        list.set(0, 1);
        list.set(2, 7);
        list.set(3, 9);

        list.print();

        //查
        int data = list.get(0);
        System.out.println("data:" + data);

        int data2 = list.get(3);
        System.out.println("data:" + data2);

        //删
        list.remove();
        list.print();

        list.remove();
        list.print();

        list.remove();
        list.print();

        list.remove();
        list.print();

        System.out.println("size:" + list.size());

    }
}
