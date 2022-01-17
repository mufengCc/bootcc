package com.cc.sys.Day04;

/**
 * 单链表
 *
 * @Author: cc
 * @Date: 2021/11/10 11:18 上午
 */
public class Node {

    public int val;

    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }


    /**
     * 新增节点
     *
     * @Param: val
     * @Author: Cc
     * @Date: 2021/11/10 11:22 上午
     **/
    public void add(int val) {
        Node newNode = new Node(val);

        if (next == null) {
            next = newNode;
            return;
        }

        while (next.next != null) {
            next = next.next;
        }

        next.next = newNode;
    }

    public static void main(String[] args) {
        Node node = new Node(1);

        node.add(2);
        node.add(3);

        System.out.println(node);

    }

}
