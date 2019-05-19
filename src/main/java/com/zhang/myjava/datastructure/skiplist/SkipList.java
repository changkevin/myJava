package com.zhang.myjava.datastructure.skiplist;

/**
 * @author kaizhi
 * create on 2019-02-13
 *
 */

class Node {
    int value = -1;
    int level; //跨越几层
    Node[] next; //指向下一个节点

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
        this.next = new Node[level]; //跨越N层就有N个下个节点
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Node{" +
                "value=" + value +
                ", level=" + level +
                ", next=");

        for (int i = 0; i < level; i++) {
            if(next[i] != null) {
                sb.append(next[i].value);
                if (i < level - 1) {
                    sb.append(",");
                }
            }
        }

        sb.append("}");

        return sb.toString();
    }
}

public class SkipList {
    //允许的最大层数
    int maxLevel = 16;

    //头结点，充当辅助
    Node head = new Node(-1, 16);

    //当前跳跃表节点的个数
    int size = 0;

    //当前跳跃表的层数，初始化为1层
    int levelCount = 1;

    public Node find(int value) {
        Node temp  = head;

        //从最上层向下层逐层查找，找到最底层小于value的最后一个值
        for(int i=levelCount -1; i>=0; i--) {
            while(temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
        }

        if(temp.next[0] != null && temp.next[0].value == value) {
            System.out.println(value + "查找成功");
            return temp.next[0];
        } else {
            return null;
        }
    }

    //为了方便，跳跃表在插入的时候，插入的节点在当前跳跃表是不存在的
    //不允许插入重复数值的节点
    public void insert(int value) {
        int level = getLevel();

        Node newNode = new Node(value, level);
        //update用于记录要插入节点的前驱
        Node[] update = new Node[level];

        Node temp = head;
        //从上到下，逐层找到要插入节点的前驱节点
        for(int i=level -1; i>=0; i--) {
            while(temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        //把插入节点的每一层连接起来
        for(int i=0; i<level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        //判断是否需要更新跳跃表的层数
        if(level > levelCount) {
            levelCount = level;
        }

        size++;
        System.out.println(value + "插入成功, levle=" + level);

    }

    public void delete(int value) {
        //update用于记录要删除节点的前驱
        Node[] update = new Node[levelCount];

        Node temp = head;
        //从上到下，逐层找到要删除节点的前驱节点
        for(int i=levelCount -1; i>=0; i--) {
            while(temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        if(temp.next[0] != null && temp.next[0].value == value) {
            size--;
            for(int i=levelCount-1; i>=0; i--) {
                if(update[i].next[i] != null && update[i].next[i].value == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }

        //如果层为空，则层数-1
        for(int i=levelCount -1; i>=0; i--) {
            if(head.next[i] == null) {
                levelCount--;
            }
        }

        System.out.println(value + "删除成功");

    }

    public void printAllNode() {
        System.out.println("------------skiplist start----------------");
        for(int i=levelCount-1; i>=0; i--) {
            Node temp = head;
            while(temp.next[i] != null) {
                System.out.print(temp.next[i].value + " ");
                temp = temp.next[i];
            }
            System.out.println("");

        }
        System.out.println("-------------skiplist end-----------------");
    }

    //模拟抛硬币
    private int getLevel() {
        int level = 1;
        while(true) {
            int t = (int)(Math.random()*100);
            if(t % 2 == 0) {
                level++;
            } else {
                break;
            }
        }

        if(level > maxLevel) level = maxLevel;

        return level;

    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        for(int i=0; i<6; i++) {
            list.insert(i);
        }

        list.printAllNode();
        list.delete(4);
        list.printAllNode();
        System.out.println(list.find(3));
        System.out.println("size:" +list.size+ ",level:" +list.levelCount );

    }


}
